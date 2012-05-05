/*
 * com/bensmann/supervise/validator/file/FilenameConstraint.java
 *
 * FilenameConstraint.java created on 20. Februar 2007, 18:24 by rb
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

import com.bensmann.validator.AbstractConstraint;
import com.bensmann.validator.Property;
import com.bensmann.validator.exception.ValidatorException;
import java.io.File;
import java.util.LinkedList;

/**
 *
 * @author rb
 * @version 1.0
 */
public class FilenameConstraint extends AbstractConstraint<File> {
    
    /**
     * Creates a new instance of FilenameConstraint
     * @param property 
     */
    public FilenameConstraint(Property[] property) {
        this.property = property;
    }
    
    /**
     * TODO
     * @param objective
     * @return
     * @throws com.bensmann.validator.exception.ValidatorException 
     */
    public boolean[] check(File objective) throws ValidatorException {
        
        boolean b[] = new boolean[0];
        /*
        boolean[] b = new boolean[objective.length];
        int i = 0;
        
        // TODO reset list matching/non-matching?
        matching = new LinkedList<File>();
        nonMatching = new LinkedList<File>();
        
        for (File f : objective) {
            
            for (Property p : property) {
                
                if (p.matches(f.getName())) {
                    b[i] = true;
                } else {
                    b[i] = false;
                    // Properties are used in an AND-conjunction:
                    // if only one Property is not met, the criteria were
                    // not met, so break loop
                    break;
                }
                
            }
            
            if (b[i]) {
                matching.add(f);
            } else {
                nonMatching.add(f);
            }
            
//            System.out.println("FilenameConstraint: "
//                    + f.getAbsolutePath()
//                    + (b[i] == true ? " matches!" : " DOES NOT match!"));
            
            i++;
            
        }
        */
        
        return b;
        
    }

    @Override
    public boolean[] check(File[] objective) throws ValidatorException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
