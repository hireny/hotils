package me.hireny.commons;

/**
 * @ClassName: HotilsRuntimeException
 * @Author: hireny
 * @Date: Create in 2019/12/09 01:38
 * @Description: TODO   基础的运行时异常
 */
public class HotilsRuntimeException extends RuntimeException {
    public HotilsRuntimeException() {
        super();
    }

    public HotilsRuntimeException(String message) {
        super(message);
    }

    public HotilsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotilsRuntimeException(Throwable cause) {
        super(cause);
    }

    protected HotilsRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
