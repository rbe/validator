/*
 * com/bensmann/supervise/validator/Property.java
 *
 * Property.java created on 20. Februar 2007, 18:29 by rb
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

/**
 *
 * @author rb
 * @version 1.0
 */
public class Property {

    /**
     *
     */
    private Operator operator;

    /**
     *
     */
    private String expectedValue;
    
    /**
     * Creates a new instance of Property
     */
    public Property(Operator operator, String expectedValue) {
        this.setOperator(operator);
        this.setExpectedValue(expectedValue);
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }
    
    /**
     * 
     * @param value 
     * @return 
     */
    public boolean matches(String value) {
        
        boolean b = false;
        
        if (operator == Operator.EQUAL) {
            if (value.equals(expectedValue)) {
                b = true;
            }
        } else if (operator == Operator.STARTS_WITH) {
            if (value.startsWith(expectedValue)) {
                b = true;
            }
        } else if (operator == Operator.ENDS_WITH) {
            if (value.endsWith(expectedValue)) {
                b = true;
            }
        } else if (operator == Operator.INDEX_OF) {
            if (value.indexOf(expectedValue) >= 0) {
                b = true;
            }
        }
        
        return b;
        
    }
    
}
