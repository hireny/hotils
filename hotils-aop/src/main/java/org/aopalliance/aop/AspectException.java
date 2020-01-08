package org.aopalliance.aop;

/**
 * @ClassName: AspectException
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:45
 * @Description: TODO   切面异常
 */
public class AspectException extends RuntimeException {
    public AspectException() {
        super();
    }

    public AspectException(String message) {
        super(message);
    }

    public AspectException(String message, Throwable cause) {
        super(message, cause);
    }

    public AspectException(Throwable cause) {
        super(cause);
    }

    protected AspectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
