package org.hotilsframework.json.exception;

/**
 * Json解析异常
 * @Author: hireny
 * @Date: Create in 2019/07/16 21:27
 */
public class JsonParseException extends JsonException {

    public JsonParseException() {
    }

    public JsonParseException(String message) {
        super(message);
    }

    public JsonParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonParseException(Throwable cause) {
        super(cause);
    }

    public JsonParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
