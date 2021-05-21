package org.hotilsframework.core.serializer;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 *
 * SerializationFailedException
 *
 * 失败的序列化异常
 *
 * @author hireny
 * @date Created in 2020-01-30 9:41
 * @version 1.0
 */
public class FailedSerializationException extends NestedRuntimeException {
    private static final long serialVersionUID = -5442276973662789706L;

    public FailedSerializationException() {
        super();
    }

    public FailedSerializationException(String message) {
        super(message);
    }

    public FailedSerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedSerializationException(Throwable cause) {
        super(cause);
    }

    protected FailedSerializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
