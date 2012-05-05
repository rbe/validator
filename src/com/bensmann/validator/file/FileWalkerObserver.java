/*
 * com/bensmann/supervise/validator/file/FileWalkerObserver.java
 *
 * FileWalkerObserver.java created on 23. Februar 2007, 17:39 by rb
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

/**
 *
 * @author rb
 */
public interface FileWalkerObserver {
    
    /**
     *
     */
    void processFoundDirectoryEvent(File file);
    
    /**
     *
     */
    void processFoundFileEvent(File file);
    
    /**
     *
     */
    void processFoundFileEvent(File[] file);
    
}
