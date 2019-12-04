package me.hireny.commons.socket;

import me.hireny.commons.HotilsException;

/**
 * @ClassName: SocketException
 * @Author: hireny
 * @Date: Create in 2019/12/01 14:00
 * @Description: TODO   Socket异常
 */
public class SocketException extends HotilsException {

    private static final long serialVersionUID = 3674006536906084422L;

    public SocketException() {
        super();
    }

    public SocketException(String message) {
        super(message);
    }

    public SocketException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocketException(Throwable cause) {
        super(cause);
    }

    protected SocketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
