package me.hireny.commons;

/**
 * @ClassName: RetortsException
 * @Author: hireny
 * @Date: Create in 2019/11/25 22:52
 * @Description: TODO   基础的异常
 */
public class RetortsException extends Exception {

    public RetortsException() {
        super();
    }

    public RetortsException(String message) {
        super(message);
    }

    public RetortsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetortsException(Throwable cause) {
        super(cause);
    }

    protected RetortsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
