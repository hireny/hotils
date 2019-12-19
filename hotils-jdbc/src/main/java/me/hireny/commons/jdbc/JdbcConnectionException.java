package me.hireny.commons.jdbc;

import me.hireny.commons.HotilsRuntimeException;

/**
 * @ClassName: JdbcConnectionException
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:32
 * @Description: TODO   JDBC连接异常
 */
public class JdbcConnectionException extends HotilsRuntimeException {

    private static final long serialVersionUID = 4313919867933853333L;

    public JdbcConnectionException() {
        super();
    }

    public JdbcConnectionException(String message) {
        super(message);
    }

    public JdbcConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcConnectionException(Throwable cause) {
        super(cause);
    }

    protected JdbcConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
