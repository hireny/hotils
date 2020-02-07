package org.hotilsframework.core.beans;

/**
 * @ClassName: FatalBeansException
 * @Author: hireny
 * @Date: Create in 2019/12/22 00:19
 * @Description: TODO
 */
public class FatalBeansException extends BeansException {

    public FatalBeansException() {
        super();
    }

    public FatalBeansException(String message) {
        super(message);
    }

    public FatalBeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalBeansException(Throwable cause) {
        super(cause);
    }

    protected FatalBeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
