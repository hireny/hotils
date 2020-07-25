package org.hotilsframework.core.generator;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * ID生成异常
 * @ClassName: IdGeneratorException
 * @Author: hireny
 * @Date: Created in 2020-01-16 0:16
 * @Version: 1.0
 */
public class FailedIdGeneratorException extends NestedRuntimeException {

    public FailedIdGeneratorException() {
        super();
    }

    public FailedIdGeneratorException(String message) {
        super(message);
    }

    public FailedIdGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedIdGeneratorException(Throwable cause) {
        super(cause);
    }

    protected FailedIdGeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
