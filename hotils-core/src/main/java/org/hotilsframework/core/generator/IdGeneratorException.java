package org.hotilsframework.core.generator;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * ID生成异常
 * @ClassName: IdGeneratorException
 * @Author: hireny
 * @Date: Created in 2020-01-16 0:16
 * @Version: 1.0
 */
public class IdGeneratorException extends NestedRuntimeException {

    public IdGeneratorException() {
        super();
    }

    public IdGeneratorException(String message) {
        super(message);
    }

    public IdGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdGeneratorException(Throwable cause) {
        super(cause);
    }

    protected IdGeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
