package org.hotilsframework.beans;

/**
 * @ClassName: InjectException
 * @Description: TODO   注入异常类
 * @Author: hireny
 * @Date: Created in 2020-01-10 2:05
 * @Version: 1.0
 */
public class InjectException extends BeansException {

    private static final long serialVersionUID = 2766187256423344323L;

    public InjectException() {
        super();
    }

    public InjectException(String message) {
        super(message);
    }

    public InjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public InjectException(Throwable cause) {
        super(cause);
    }

    protected InjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
