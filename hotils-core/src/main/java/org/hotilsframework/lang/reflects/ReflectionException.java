package org.hotilsframework.lang.reflects;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 反射异常
 * @className ReflectionException
 * @author hireny
 * @date Created in 2020-02-12 13:36
 */
public class ReflectionException extends NestedRuntimeException {
    private static final long serialVersionUID = 8392796672704439936L;

    public ReflectionException() {
        super();
    }

    public ReflectionException(String message) {
        super(message);
    }

    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionException(Throwable cause) {
        super(cause);
    }

    protected ReflectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
