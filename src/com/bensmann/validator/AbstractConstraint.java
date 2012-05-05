/*
 * com/bensmann/supervise/validator/AbstractConstraint.java
 *
 * AbstractConstraint.java created on 20. Februar 2007, 18:25 by rb
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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rb
 * @version 1.0
 */
public abstract class AbstractConstraint<E> implements Constraint<E> {
    
    /**
     *
     */
    protected Property[] property;
    
    /**
     *
     */
    protected List<E> matching;
    
    /**
     *
     */
    protected List<E> nonMatching;
    
    /**
     * Creates a new instance of AbstractConstraint
     */
    public AbstractConstraint() {
        matching = new LinkedList<E>();
        nonMatching = new LinkedList<E>();
    }
    
    public void setProperty(Property[] property) {
        this.property = property;
    }

    public abstract boolean[] check(E[] objective) throws ValidatorException;

    public List<E> getMatching() {
        return matching;
    }

    public List<E> getNonMatching() {
        return nonMatching;
    }
    
}
