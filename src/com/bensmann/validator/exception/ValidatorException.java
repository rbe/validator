/*
 * com/bensmann/supervise/exception/ValidatorException.java
 *
 * ValidatorException.java created on 16. Februar 2007, 10:07 by rb
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

package com.bensmann.validator.exception;

import java.util.List;

/**
 *
 * @author rb
 * @version 1.0
 */
public class ValidatorException extends Exception /*extends SuperviseException*/ {
    
    private List<ValidatorException> exceptions;
    
    /**
     * Creates a new instance of ValidatorException
     * 
     * 
     * @param message
     */
    public ValidatorException(String message) {
        super(message);
    }
    
    /**
     *
     * @param message
     * @param throwable
     */
    public ValidatorException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    /**
     * 
     * @param message 
     * @param exceptions 
     */
    public ValidatorException(String message, List<ValidatorException> exceptions) {
        super(message);
        this.exceptions = exceptions;
    }
    
}
