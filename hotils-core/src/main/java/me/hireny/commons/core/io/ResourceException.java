package me.hireny.commons.core.io;

import me.hireny.commons.HotilsException;

/**
 * ResourceException
 * 资源异常
 *
 * @Author: hireny
 * @Date: Create in 2019/10/05 22:56
 */
public class ResourceException extends HotilsException {

    public ResourceException() {
        super();
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }

    protected ResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
