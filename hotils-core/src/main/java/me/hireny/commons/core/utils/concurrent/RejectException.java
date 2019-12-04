package me.hireny.commons.core.utils.concurrent;

import me.hireny.commons.HotilsException;

/**
 * @ClassName: RejectException
 * @Author: hireny
 * @Date: Create in 2019/12/04 13:41
 * @Description: TODO   拒绝异常类
 */
public class RejectException extends HotilsException {
    public RejectException() {
        super();
    }

    public RejectException(String message) {
        super(message);
    }

    public RejectException(String message, Throwable cause) {
        super(message, cause);
    }

    public RejectException(Throwable cause) {
        super(cause);
    }

    protected RejectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
