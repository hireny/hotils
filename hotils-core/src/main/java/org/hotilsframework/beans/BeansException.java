package org.hotilsframework.beans;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * @ClassName: BeansException
 * @Author: hireny
 * @Date: Create in 2019/12/22 00:31
 * @Description: TODO   Bean异常
 */
public class BeansException extends NestedRuntimeException {

    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }

    protected BeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
