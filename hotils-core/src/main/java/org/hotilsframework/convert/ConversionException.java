package org.hotilsframework.convert;

import org.hotilsframework.lang.NestedRuntimeException;

/**
 * @ClassName: ConversionException
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:53
 * @Description: TODO   转换异常
 */
public class ConversionException extends NestedRuntimeException {

    public ConversionException() {
        super();
    }

    public ConversionException(String message) {
        super(message);
    }

    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversionException(Throwable cause) {
        super(cause);
    }

    protected ConversionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
