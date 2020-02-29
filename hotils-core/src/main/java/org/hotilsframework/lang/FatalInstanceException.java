package org.hotilsframework.lang;

/**
 * 这个异常主要针对：对类进行实例化失败。
 * @author hireny
 * @className CannotInstanceException
 * @create 2020-02-21 21:25
 */
public class FatalInstanceException extends NestedRuntimeException {
    private static final long serialVersionUID = 4251359161254269742L;

    public FatalInstanceException() {
        super();
    }

    public FatalInstanceException(String message) {
        super(message);
    }

    public FatalInstanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalInstanceException(Throwable cause) {
        super(cause);
    }

    protected FatalInstanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
