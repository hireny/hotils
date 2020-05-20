package org.hotilsframework.core.collect;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 没有这样的集合类型异常
 *
 * @ClassName: NoSuchListTypeException
 * @Author: hireny
 * @Date: Created in 2020-01-11 8:24
 * @Version: 1.0
 */
public class NoSuchListTypeException extends NestedRuntimeException {

    private static final long serialVersionUID = -3245711526980365546L;

    public NoSuchListTypeException() {
        super();
    }

    public NoSuchListTypeException(String message) {
        super(message);
    }

    public NoSuchListTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchListTypeException(Throwable cause) {
        super(cause);
    }

    protected NoSuchListTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
