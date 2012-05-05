/*
 * com/bensmann/supervise/validator/FileWalker.java
 *
 * FileWalker.java created on 23. Februar 2007, 17:37 by rb
 *
 * Copyright (C) 2006-2007 Ralf Bensmann, java@bensmann.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA
 *
 */

package com.bensmann.validator.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author rb
 * @version 1.0
 */
public class FileWalker {
    
    /**
     *
     */
    private ExecutorService pool;
    
    /**
     *
     */
    private List<FileWalkerObserver> observer;
    
    /**
     * List of FileWalker threads
     */
    private List<Walker> walkerThread;
    
    /**
     * Size of walkerThread pool
     */
    private int poolSize;
    
    /**
     *
     */
    class Walker implements Runnable {
        
        /**
         *
         */
        private File file;
        
        /**
         *
         */
        private List<File> foundFiles = new LinkedList<File>();
        
        /**
         * Has this walkerThread finished work?
         */
        private boolean finished;
        
        /**
         *
         * @param file
         */
        public Walker() {
            // When this thread is created there's no work to do
            finished = true;
        }
        
        /**
         *
         * @param file
         */
        public Walker(File file) {
            
            this.file = file;
            
            // When this thread is created there's no work to do
            finished = true;
            
        }
        
        /**
         *
         * @param file
         */
        public void setFile(File file) {
            this.file = file;
        }
        
        /**
         *
         * @return
         */
        public boolean isFinished() {
            return finished;
        }
        
        /**
         *
         */
        public void run() {
            
            // Start work; we are not finished
            finished = false;
            
            for (File f : file.listFiles()) {
                
                if (f.isFile()) {
                    foundFiles.add(f);
//                    fireFileFoundEvent(f);
                } else if (f.isDirectory()) {
                    fireDirectoryFoundEvent(f);
                    walk(f);
                }
                
            }
            
            // Work done; inform observer
            finished = true;
            fireFileFoundEvent(foundFiles.toArray(new File[foundFiles.size()]));
            
        }
        
    }
    
    /**
     * Creates a new instance of FileWalker
     */
    public FileWalker() {
        this(5);
    }
    
    /**
     * Creates a new instance of FileWalker
     *
     * @param poolSize Number of threads used for traversing directories
     */
    public FileWalker(int poolSize) {
        this.poolSize = poolSize;
        walkerThread = new LinkedList<Walker>();
        pool = Executors.newFixedThreadPool(poolSize);
        observer = new LinkedList<FileWalkerObserver>();
    }
    
    /**
     *
     * @param observer
     */
    public synchronized void registerObserver(FileWalkerObserver observer) {
        this.observer.add(observer);
    }
    
    /**
     *
     * @param observer
     */
    public synchronized void deregisterObserver(FileWalkerObserver observer) {
        this.observer.remove(observer);
    }
    
    /**
     *
     * @param file
     */
    private synchronized void fireDirectoryFoundEvent(File file) {
        for (FileWalkerObserver o : observer) {
            o.processFoundDirectoryEvent(file);
        }
    }
    
    /**
     *
     * @param file
     */
    private synchronized void fireFileFoundEvent(File file) {
        for (FileWalkerObserver o : observer) {
            o.processFoundFileEvent(file);
        }
    }
    
    /**
     *
     * @param file
     */
    private synchronized void fireFileFoundEvent(File[] file) {
        for (FileWalkerObserver o : observer) {
            o.processFoundFileEvent(file);
        }
    }
    
    /**
     *
     * @param file
     */
    public synchronized void walk(File file) {
        
        Walker walker = null;
        
//        if (walkerThread.size() < poolSize) {
//            // Create new Walker
//            walker = new Walker(file);
//            walkerThread.add(walker);
//        } else {
//            // Find an finished Walker
//            for (Walker w : walkerThread) {
//                if (w.isFinished()) {
//                    walker = w;
//                    break;
//                }
//            }
//        }
        
        walker = new Walker(file);
        if (walker != null) {
            pool.execute(walker);
        }
        
    }
    
    /**
     *
     */
    public void shutdown() {
        pool.shutdown();
    }
    
}
