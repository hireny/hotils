package org.hotilsframework.math;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 数学异常
 * @author hireny
 * @className MathsException
 * @create 2020-02-21 22:58
 */
public class MathException extends NestedRuntimeException {
    private static final long serialVersionUID = -726427750027475404L;

    public MathException() {
        super();
    }

    public MathException(String message) {
        super(message);
    }

    public MathException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathException(Throwable cause) {
        super(cause);
    }

    protected MathException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
