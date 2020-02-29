package org.hotilsframework.lang;

/**
 * @ClassName: NestedException
 * @Author: hireny
 * @Date: Created in 2020-01-30 9:47
 * @Version: 1.0
 */
public class NestedException extends Exception {

    private static final long serialVersionUID = -4179821379400836579L;

    public NestedException() {
        super();
    }

    public NestedException(String message) {
        super(message);
    }

    public NestedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NestedException(Throwable cause) {
        super(cause);
    }

    protected NestedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
