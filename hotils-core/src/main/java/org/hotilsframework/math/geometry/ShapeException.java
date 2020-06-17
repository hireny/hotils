package org.hotilsframework.math.geometry;

import org.hotilsframework.math.MathsException;

/**
 * 几何形状异常
 * @author hireny
 * @className ShapeException
 * @create 2020-02-21 22:58
 */
public class ShapeException extends MathsException {
    private static final long serialVersionUID = -7451185955720094887L;

    public ShapeException() {
        super();
    }

    public ShapeException(String message) {
        super(message);
    }

    public ShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeException(Throwable cause) {
        super(cause);
    }

    protected ShapeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
