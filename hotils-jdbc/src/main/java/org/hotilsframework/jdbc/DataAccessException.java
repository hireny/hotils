package org.hotilsframework.jdbc;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * @ClassName: DataAccessException
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:31
 * @Description: TODO   数据处理异常
 */
public class DataAccessException extends NestedRuntimeException {
    private static final long serialVersionUID = 5455046653376834286L;

    public DataAccessException() {
        super();
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    protected DataAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
