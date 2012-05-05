/*
 * com/bensmann/supervise/fscheck/StandardValidator.java
 *
 * StandardValidator.java created on 16. Februar 2007, 11:07 by rb
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
import com.bensmann.validator.file.FileWalker;
import com.bensmann.validator.file.FileWalkerObserver;
import com.bensmann.validator.file.FilenameConstraint;
import com.bensmann.validator.file.ReportFileCommand;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @param E 
 * @author rb
 * @version 1.0
 */
public class StandardValidator<E> implements Validator<E> {

    /**
     * An array of type Constraint that must apply
     */
    private Constraint<E>[] constraint;

    /**
     * One or more commands to execute when one or more constraints apply
     * to files and/or directories found by matchMask
     */
    private Command<E>[] whenMatchCommand;

    /**
     * One or more commands to execute when one or more constraints DO NOT apply
     * to files and/or directories found by matchMask
     */
    private Command<E>[] whenDontMatchCommand;

    /**
     *
     */
    public StandardValidator() {
    }

    /**
     * Creates a new instance of StandardValidator
     *
     * @param whenMatchCommand
     * @param whenDontMatchCommand
     */
    public StandardValidator(Command<E>[] whenMatchCommand,
            Command<E>[] whenDontMatchCommand) {

        this.whenMatchCommand = whenMatchCommand;
        this.whenDontMatchCommand = whenDontMatchCommand;

    }

    /**
     * Creates a new instance of StandardValidator
     *
     * @param constraint
     * @param whenMatchCommand
     * @param whenDontMatchCommand
     */
    public StandardValidator(Constraint<E>[] constraint,
            Command<E>[] whenMatchCommand, Command<E>[] whenDontMatchCommand) {

        this.constraint = constraint;
        this.whenMatchCommand = whenMatchCommand;
        this.whenDontMatchCommand = whenDontMatchCommand;

    }

    /**
     * Set constraint(s) to check against files and/or directories found by
     * matchMask. If more than one contraint is given, the constraints are
     * tied together with an AND operation: all must apply.
     *
     * @param constraint An array of type Constraint
     */
    public void setConstraint(Constraint<E>[] constraint) {
        this.constraint = constraint;
    }

    public void setWhenMatchCommand(Command<E>[] whenMatchCommand) {
        this.whenMatchCommand = whenMatchCommand;
    }

    public void setWhenDontMatchCommand(Command<E>[] whenDontMatchCommand) {
        this.whenDontMatchCommand = whenDontMatchCommand;
    }

    /**
     *
     * @param command
     * @throws com.bensmann.validator.exception.ValidatorException
     *      Is thrown when any execution of a Command throwed an error.
     *      Use ValidatorException.getExceptions() to get a list of all
     *      exceptions.
     */
    public void processCommand(Command<E>[] command, Constraint<E>[] constraint, boolean match)
            throws ValidatorException {

        // List with all exception occured when executing commands
        List<ValidatorException> exceptions =
                new LinkedList<ValidatorException>();

        for (Command<E> cmd : command) {

            for (Constraint<E> constr : constraint) {

                // Process matching or non-matching objectives?
                if (match) {
                    cmd.setObjective(constr.getMatching());
                } else {
                    cmd.setObjective(constr.getNonMatching());
                }

                try {
                    cmd.execute();
                } catch (ValidatorException e) {
                    // Save exception in list
                    exceptions.add(e);
                }

            }

        }

        // When any exceptions were thrown during command execution,
        // throw an exception with the list of exceptions occured
        if (exceptions.size() > 0) {
            throw new ValidatorException("Errors occured when executing command",
                    exceptions //                    .toArray(new ValidatorException[exceptions.size()])
                    );
        }

        exceptions = null;

    }

    public void doWhenConstraintMatches() throws ValidatorException {
        processCommand(whenMatchCommand, constraint, true);
    }

    public void doWhenConstraintNotMatches() throws ValidatorException {
        processCommand(whenDontMatchCommand, constraint, false);
    }

    public static void main(String[] args) throws Exception {

        FileWalker fileWalker = new FileWalker();
        final StandardValidator<File> validator;
        final Constraint<File> filenameConstraint;

        filenameConstraint = new FilenameConstraint(new Property[]{new Property(Operator.STARTS_WITH, "a"),
                new Property(Operator.ENDS_WITH, ".txt")});

        validator = new StandardValidator<File>(new Command[]{new ReportFileCommand()},
                new Command[]
         {});
        validator.setConstraint(new Constraint 

                    [] { filenameConstraint });
        
        fileWalker.registerObserver(new FileWalkerObserver() {
            
            public void processFoundDirectoryEvent(File file) {
                    }

                    public void processFoundFileEvent(File file) {
                    }

                    public void processFoundFileEvent(File[] file) {
                        try {
                            filenameConstraint.check(file);
                            validator.doWhenConstraintMatches();
                        } catch (ValidatorException ex) {
                        }
                    }

                });

        fileWalker.walk(new File("c:/workspace/software"));

    }

}
