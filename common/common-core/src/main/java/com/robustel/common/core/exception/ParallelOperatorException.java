package com.robustel.common.core.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by leicheng on 2015/10/20.
 */
public class ParallelOperatorException extends RuntimeException {
	private static final long serialVersionUID = 5338727541395256858L;
	private Collection<? extends Throwable> exceptions;

    public ParallelOperatorException() {
        super();
    }

    public ParallelOperatorException(String message) {
        super(message);
    }

    public ParallelOperatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParallelOperatorException(Throwable cause) {
        super(cause);
    }

    protected ParallelOperatorException(String message, Throwable cause,
                                        boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ParallelOperatorException setExceptions(Collection<? extends Throwable> exceptions) {
        this.exceptions = exceptions;
        return this;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        if (exceptions != null) {
            for (Throwable exception : exceptions) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        if (exceptions != null) {
            for (Throwable exception : exceptions) {
                exception.printStackTrace(s);
            }
        }
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        if (exceptions != null) {
            for (Throwable exception : exceptions) {
                exception.printStackTrace(s);
            }
        }
    }
}
