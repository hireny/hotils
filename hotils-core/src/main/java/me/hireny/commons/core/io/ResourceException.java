package me.hireny.commons.core.io;

/**
 * ResourceException
 * 资源异常
 *
 * @Author: hireny
 * @Date: Create in 2019/10/05 22:56
 */
public class ResourceException extends RuntimeException {

    public ResourceException() {
        super();
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}
