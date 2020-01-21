package org.hotilsframework.jdbc;

import org.hotilsframework.NestedRuntimeException;

/**
 * @ClassName: SQLWaringException
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:33
 * @Description: TODO   SQL错误异常
 */
public class SQLWaringException extends NestedRuntimeException {
    private static final long serialVersionUID = 2542010725802206030L;

    public SQLWaringException() {
        super();
    }

    public SQLWaringException(String message) {
        super(message);
    }

    public SQLWaringException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLWaringException(Throwable cause) {
        super(cause);
    }

    protected SQLWaringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
