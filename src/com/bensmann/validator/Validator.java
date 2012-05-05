/*
 * com/bensmann/supervise/fscheck/Validator.java
 *
 * Validator.java created on 16. Februar 2007, 14:42 by rb
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


/**
 *
 * @param E 
 * @author rb
 */
public interface Validator<E> {
    
    /**
     *
     * 
     * @throws com.bensmann.validator.exception.ValidatorException 
     */
    void doWhenConstraintMatches() throws ValidatorException;
    
    /**
     *
     * 
     * @throws com.bensmann.validator.exception.ValidatorException 
     */
    void doWhenConstraintNotMatches() throws ValidatorException;
    
    /**
     *
     * @param command
     * @param constraint 
     * @param match true = process matching, false = process non-matching
     * @throws com.bensmann.validator.exception.ValidatorException
     *      Is thrown when any execution of a Command throwed an error.
     *      Use ValidatorException.getExceptions to get a list of all
     *      exceptions.
     */
    void processCommand(
            Command<E>[] command, Constraint<E>[] constraint, boolean match)
            throws ValidatorException;
    
    /**
     * Set constraint(s) to check against files and/or directories found by
     * matchMask. If more than one contraint is given, the constraints are
     * tied together with an AND operation: all must apply.
     *
     * @param constraint An array of type Constraint
     */
    void setConstraint(Constraint<E>[] constraint);
    
    /**
     *
     *
     * @param whenDontMatchCommand
     */
    void setWhenDontMatchCommand(Command<E>[] whenDontMatchCommand);
    
    /**
     *
     *
     * @param whenMatchCommand
     */
    void setWhenMatchCommand(Command<E>[] whenMatchCommand);
    
}
