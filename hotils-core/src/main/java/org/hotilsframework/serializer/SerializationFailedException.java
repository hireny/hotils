package org.hotilsframework.serializer;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * 序列化失败异常
 * @ClassName: SerializationFailedException
 * @Author: hireny
 * @Date: Created in 2020-01-30 9:41
 * @Version: 1.0
 */
public class SerializationFailedException extends NestedRuntimeException {
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
