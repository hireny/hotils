package org.hayros.beans;

/**
 * @ClassName: BeansException
 * @Author: hireny
 * @Date: Create in 2020/01/06 02:20
 * @Description: TODO   Bean异常
 */
public class BeansException extends RuntimeException {

    private static final long serialVersionUID = 9084092095095184196L;

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
