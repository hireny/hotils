package org.hotilsframework.core.copy;

import org.hotilsframework.core.lang.NestedRuntimeException;

/**
 * 复制异常
 * @ClassName: CopyException
 * @Author: hireny
 * @Date: Created in 2020-02-07 15:49
 * @Version: 1.0
 */
public class CopyException extends NestedRuntimeException {
    private static final long serialVersionUID = -8435153458971590479L;

    public CopyException() {
        super();
    }

    public CopyException(String message) {
        super(message);
    }

    public CopyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CopyException(Throwable cause) {
        super(cause);
    }

    protected CopyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
