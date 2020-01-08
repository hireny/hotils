package me.hireny.commons.core.codec;


import me.hireny.commons.core.primitives.Bytes;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * CodecSupport
 * 编解码支持
 * @Author: hireny
 * @Date: Create in 2019/10/03 14:14
 */
public abstract class CodecSupport {

    private CodecSupport() {}

    /**
     * 项目默认首选字符编码，等于 {@code UTF-8}
     */
    public static final String PREFERRED_ENCODING = "UTF-8";

    byte[] toBytes(char[] chars, String encoding) throws CodecException {
        return toBytes(new String(chars), encoding);
    }

    byte[] toBytes(String source, String encoding) throws CodecException {
        try {
            return source.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            String msg = "Unable to convert source [" + source + "] to byte array using " +
                    "encoding '" + encoding + "'";
            throw new CodecException(msg, e);
        }
    }

    String toString(byte[] bytes, String encoding) throws CodecException {
        try {
            return new String(bytes, encoding);
        } catch (UnsupportedEncodingException e) {
            String msg = "Unable to convert byte array to String with encoding '" + encoding + "'.";
            throw new CodecException(msg, e);
        }
    }

    char[] toChars(byte[] bytes, String encoding) throws CodecException {
        return toString(bytes, encoding).toCharArray();
    }

    protected boolean isByteSource(Object o) {
        return o instanceof byte[] || o instanceof char[] || o instanceof String ||
                o instanceof Bytes || o instanceof File || o instanceof InputStream;
    }

    protected byte[] toBytes(Object o) throws CodecException {
        if (o == null) {
            String msg = "Argument for byte conversion cannot be null.";
            throw new IllegalArgumentException(msg);
        }
        if (o instanceof byte[]) {
            return (byte[]) o;
        } else if (o instanceof Bytes) {
            return ((Bytes) o).getBytes();
        } else if (o instanceof char[]) {
            return toBytes((char[]) o);
        } else if (o instanceof String) {
            return toBytes((String) o);
        } else if (o instanceof File) {
            return toBytes((File) o);
        } else if (o instanceof InputStream) {
            return toBytes((InputStream) o);
        } else {
            return objectToBytes(o);
        }
    }

    protected byte[] objectToBytes(Object o) throws CodecException {
        String msg = "The " + getClass().getName() + " implementation only supports conversion to " +
                "byte[] if the source is of type byte[], char[], String, " + Bytes.class.getName() +
                " File or InputStream.  The instance provided as a method " +
                "argument is of type [" + o.getClass().getName() + "].  If you would like to convert " +
                "this argument type to a byte[], you can 1) convert the argument to one of the supported types " +
                "yourself and then use that as the method argument or 2) subclass " + getClass().getName() +
                "and override the objectToBytes(Object o) method.";
        throw new CodecException(msg);
    }

    protected String objectToString(Object o) {
        return o.toString();
    }
}
