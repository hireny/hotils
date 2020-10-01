package org.hotilsframework.core.serializer;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 序列化失败异常
 * @className SerializationFailedException
 * @author hireny
 * @date Created in 2020-01-30 9:41
 * @version 1.0
 */
public class SerializationFailedException extends NestedRuntimeException {
    private static final long serialVersionUID = -5442276973662789706L;

    public SerializationFailedException() {
        super();
    }

    public SerializationFailedException(String message) {
        super(message);
    }

    public SerializationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationFailedException(Throwable cause) {
        super(cause);
    }

    protected SerializationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
