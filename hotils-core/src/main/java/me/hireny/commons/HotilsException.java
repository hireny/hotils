package me.hireny.commons;

/**
 * @ClassName: HotilsException
 * @Author: hireny
 * @Date: Create in 2019/11/25 22:52
 * @Description: TODO   基础的异常
 */
public class HotilsException extends Exception {

    public HotilsException() {
        super();
    }

    public HotilsException(String message) {
        super(message);
    }

    public HotilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotilsException(Throwable cause) {
        super(cause);
    }

    protected HotilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
