/*
 * com/bensmann/supervise/fscheck/Command.java
 *
 * Command.java created on 16. Februar 2007, 10:37 by rb
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
 * Describe one certain thing to do
 *
 * @param E 
 * @author rb
 */
public interface Command<E> {
    
    /**
     * File object to be checked (can be a objective or a directory)
     * 
     * 
     * @param objective
     */
    void setObjective(List<E> objective);

    /**
     * 
     * 
     * @throws ValidatorException
     */
    void execute() throws ValidatorException;
    
}
