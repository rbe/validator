/*
 * com/bensmann/supervise/validator/file/ReportFileCommand.java
 *
 * ReportFileCommand.java created on 23. Februar 2007, 19:22 by rb
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

import com.bensmann.validator.Command;
import com.bensmann.validator.exception.ValidatorException;
import java.io.File;
import java.util.List;

/**
 *
 * @author rb
 * @version 1.0
 */
public class ReportFileCommand implements Command<File> {

    /**
     *
     */
    private List<File> objective;

    /**
     * Creates a new instance of ReportFileCommand
     */
    public ReportFileCommand() {
    }

    public void setObjective(List<File> objective) {
        this.objective = objective;
    }

    public void execute() throws ValidatorException {
        System.out.println("objective.length=" + objective.size());
        for (File f : objective) {
            System.out.println("found: " + f.getAbsolutePath());
        }
    }

}
