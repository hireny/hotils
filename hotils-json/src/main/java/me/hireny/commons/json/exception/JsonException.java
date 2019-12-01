package me.hireny.commons.json.exception;

import me.hireny.commons.RetortsException;

/**
 * Json异常
 * @Author: hireny
 * @Date: Create in 2019/07/16 21:28
 */
public class JsonException extends RetortsException {

    public JsonException() {
    }

    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }

    public JsonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
