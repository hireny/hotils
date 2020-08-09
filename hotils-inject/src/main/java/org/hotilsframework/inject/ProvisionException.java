package org.hotilsframework.inject;

/**
 * ProvisionException
 *
 * 使用Provider获取提供的对象错误
 *
 * @author hireny
 * @create 2020-08-08 16:35
 */
public class ProvisionException extends Exception {
    private static final long serialVersionUID = -3061153603532154815L;

    public ProvisionException() {
        super();
    }

    public ProvisionException(String message) {
        super(message);
    }

    public ProvisionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProvisionException(Throwable cause) {
        super(cause);
    }

    protected ProvisionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
