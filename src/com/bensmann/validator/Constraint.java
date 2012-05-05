/*
 * com/bensmann/supervise/fscheck/Constraint.java
 *
 * Constraint.java created on 16. Februar 2007, 10:13 by rb
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
 * Describes a constraint that will be checked against a given
 * file or directory
 *
 * @param E 
 * @author rb
 * @version 1.0
 */
public interface Constraint<E> {
    
    /**
     *
     * 
     * @param property 
     */
    void setProperty(Property[] property);
    
    /**
     * Perform check of this contraint against given files or directories
     * 
     * @param objective
     * @return
     * @throws com.bensmann.validator.exception.ValidatorException 
     */
    boolean[] check(E[] objective) throws ValidatorException;
    
    /**
     *
     * @return
     */
    List<E> getMatching();
    
    /**
     *
     * @return
     */
    List<E> getNonMatching();
    
}
