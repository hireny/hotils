package org.hotilsframework.json.exception;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/21 22:47
 */
public class JsonTypeException extends JsonException {
    public JsonTypeException() {
        super();
    }

    public JsonTypeException(String message) {
        super(message);
    }

    public JsonTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonTypeException(Throwable cause) {
        super(cause);
    }

    public JsonTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
