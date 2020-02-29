package org.hotilsframework.lang;

/**
 * 索引失败的异常
 * @author hireny
 * @className FatalIndexException
 * @create 2020-02-21 21:28
 */
public class FatalIndexException extends NestedRuntimeException {
    private static final long serialVersionUID = 3056196523321728957L;

    public FatalIndexException() {
        super();
    }

    public FatalIndexException(String message) {
        super(message);
    }

    public FatalIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalIndexException(Throwable cause) {
        super(cause);
    }

    protected FatalIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
