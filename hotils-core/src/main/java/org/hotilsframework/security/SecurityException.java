package org.hotilsframework.security;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 安全异常
 * @author hireny
 * @className SecurityException
 * @create 2020-02-20 23:08
 */
public class SecurityException extends NestedRuntimeException {
    private static final long serialVersionUID = -2053296462034376194L;

    public SecurityException() {
        super();
    }

    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityException(Throwable cause) {
        super(cause);
    }

    protected SecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
