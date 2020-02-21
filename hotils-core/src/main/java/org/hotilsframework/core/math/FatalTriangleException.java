package org.hotilsframework.core.math;

/**
 * 三角形构建失败异常
 * @author hireny
 * @className FatalTriangleException
 * @create 2020-02-21 23:00
 */
public class FatalTriangleException extends ShapeException {
    private static final long serialVersionUID = 3637233769987931934L;

    public FatalTriangleException() {
        super();
    }

    public FatalTriangleException(String message) {
        super(message);
    }

    public FatalTriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalTriangleException(Throwable cause) {
        super(cause);
    }

    protected FatalTriangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
