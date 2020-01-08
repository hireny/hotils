package me.hireny.commons.core.convert;

/**
 * @ClassName: ConversionFailedException
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:52
 * @Description: TODO   转换失败异常
 */
public class ConversionFailedException extends ConversionException {

    public ConversionFailedException() {
        super();
    }

    public ConversionFailedException(String message) {
        super(message);
    }

    public ConversionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversionFailedException(Throwable cause) {
        super(cause);
    }

    protected ConversionFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
