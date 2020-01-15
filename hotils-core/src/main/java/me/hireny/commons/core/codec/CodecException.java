package me.hireny.commons.core.codec;

/**
 * CodecException
 * 编解码异常
 * @Author: hireny
 * @Date: Create in 2019/10/04 10:10
 */
public class CodecException extends Exception {

    public CodecException() {
        super();
    }

    public CodecException(String message) {
        super(message);
    }

    public CodecException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodecException(Throwable cause) {
        super(cause);
    }

    protected CodecException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
