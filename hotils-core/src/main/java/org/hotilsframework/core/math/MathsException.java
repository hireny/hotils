package org.hotilsframework.core.math;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 数学异常
 * @author hireny
 * @className MathsException
 * @create 2020-02-21 22:58
 */
public class MathsException extends NestedRuntimeException {
    private static final long serialVersionUID = -726427750027475404L;

    public MathsException() {
        super();
    }

    public MathsException(String message) {
        super(message);
    }

    public MathsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathsException(Throwable cause) {
        super(cause);
    }

    protected MathsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
