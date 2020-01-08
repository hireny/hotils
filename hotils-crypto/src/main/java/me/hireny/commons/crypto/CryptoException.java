package me.hireny.commons.crypto;

import me.hireny.commons.NestedRuntimeException;

/**
 * @ClassName: CryptoException
 * @Author: hireny
 * @Date: Create in 2020/01/06 02:06
 * @Description: TODO   加密异常
 */
public class CryptoException extends NestedRuntimeException {

    private static final long serialVersionUID = 8488483361968158602L;

    public CryptoException() {
        super();
    }

    public CryptoException(String message) {
        super(message);
    }

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoException(Throwable cause) {
        super(cause);
    }

    protected CryptoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
