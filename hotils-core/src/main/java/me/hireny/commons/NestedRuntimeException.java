package me.hireny.commons;

/**
 * @ClassName: HotilsRuntimeException
 * @Author: hireny
 * @Date: Create in 2019/12/09 01:38
 * @Description: TODO   嵌套的运行时异常
 */
public class NestedRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6349020547767422108L;

    public NestedRuntimeException() {
        super();
    }

    public NestedRuntimeException(String message) {
        super(message);
    }

    public NestedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NestedRuntimeException(Throwable cause) {
        super(cause);
    }

    protected NestedRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
