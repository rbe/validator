/*
 * com/bensmann/supervise/check/MatchMask.java
 *
 * MatchMask.java created on 16. Februar 2007, 09:53 by rb
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

package com.bensmann.validator;

import com.bensmann.validator.exception.ValidatorException;
import java.util.List;

/**
 * Set properties for files and/or directories to work with. These
 * files and/or directories will be checked againts classes of type Contraint.
 *
 * @param E 
 * @author rb
 * @version 1.0
 */
public interface MatchMask<E> {
    
    /**
     *
     * @param property 
     */
    void setProperty(Property[] property);
    
    /**
     * Check given properties against files or directories
     *
     * @param file
     * @return
     * @throws com.bensmann.validator.exception.ValidatorException 
     */
    boolean check(E[] file) throws ValidatorException;
    
    /**
     * All files and/or directories that have matched by given properties
     *
     * @return File[]
     */
    List<E> getMatching();
    
    /**
     * All files and/or directories that NOT have matched by given properties
     *
     * @return File[]
     */
    List<E> getNonMatching();
    
}
