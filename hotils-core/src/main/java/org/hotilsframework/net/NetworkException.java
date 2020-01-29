package org.hotilsframework.net;

import org.hotilsframework.NestedRuntimeException;

/**
 * @ClassName: NetworkException
 * @Author: hireny
 * @Date: Create in 2019/12/08 00:36
 * @Description: TODO 网络异常
 */
public class NetworkException extends NestedRuntimeException {

    public NetworkException() {
        super();
    }

    public NetworkException(String message) {
        super(message);
    }

    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkException(Throwable cause) {
        super(cause);
    }

    protected NetworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
