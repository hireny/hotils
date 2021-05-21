package org.hotilsframework.codec;

import java.io.File;
import java.io.InputStream;

/**
 * ByteUtils
 * 
 * 字节工具类
 *
 * @author hireny
 * @create 2021-05-20 21:26
 */
public class ByteUtils {
    /**
     * Returns a new {@code ByteDefinition} instance representing the specified byte array.
     *
     * @param bytes the bytes to represent as a {@code ByteDefinition} instance.
     * @return a new {@code ByteDefinition} instance representing the specified byte array.
     */
    public static ByteDefinition bytes(byte[] bytes) {
        return null;
    }

    /**
     * Returns a new {@code ByteDefinition} instance representing the specified character array's bytes.  The byte
     * array is obtained assuming {@code UTF-8} encoding.
     *
     * @param chars the character array to represent as a {@code ByteDefinition} instance.
     * @return a new {@code ByteDefinition} instance representing the specified character array's bytes.
     */
    public static ByteDefinition bytes(char[] chars) {
        return null;
    }

    /**
     * Returns a new {@code ByteDefinition} instance representing the specified string's bytes.  The byte
     * array is obtained assuming {@code UTF-8} encoding.
     *
     * @param string the string to represent as a {@code ByteDefinition} instance.
     * @return a new {@code ByteDefinition} instance representing the specified string's bytes.
     */
    public static ByteDefinition bytes(String string) {
        return null;
    }

    /**
     * Returns a new {@code ByteDefinition} instance representing the specified ByteDefinition.
     *
     * @param source the ByteDefinition to represent as a new {@code ByteDefinition} instance.
     * @return a new {@code ByteDefinition} instance representing the specified ByteDefinition.
     */
    public static ByteDefinition bytes(ByteDefinition source) {
        return null;
    }

    /**
     * Returns a new {@code ByteDefinition} instance representing the specified File's bytes.
     *
     * @param file the file to represent as a {@code ByteDefinition} instance.
     * @return a new {@code ByteDefinition} instance representing the specified File's bytes.
     */
    public static ByteDefinition bytes(File file) {
        return null;
    }

    /**
     * Returns a new {@code ByteDefinition} instance representing the specified InputStream's bytes.
     *
     * @param stream the InputStream to represent as a {@code ByteDefinition} instance.
     * @return a new {@code ByteDefinition} instance representing the specified InputStream's bytes.
     */
    public static ByteDefinition bytes(InputStream stream) {
        return null;
    }

    /**
     * 判断资源是否可以转换为ByteDefinition
     * @param source
     * @return
     */
    public static boolean isCompatible(Object source) {
        return false;
    }

    /**
     * 将资源转换为ByteDefinition
     * @param source
     * @return
     * @throws IllegalArgumentException
     */
    public static ByteDefinition bytes(Object source) throws IllegalArgumentException {
        if (source == null) {
            return null;
        }
        if (!isCompatible(source)) {
            String msg = "Unable to heuristically acquire bytes for object of type [" +
                    source.getClass().getName() + "].  If this type is indeed a byte-backed data type, you might " +
                    "want to write your own ByteDefinition implementation to extract its bytes explicitly.";
            throw new IllegalArgumentException(msg);
        }
        if (source instanceof byte[]) {
            return bytes((byte[]) source);
        } else if (source instanceof ByteDefinition) {
            return (ByteDefinition) source;
        } else if (source instanceof char[]) {
            return bytes((char[]) source);
        } else if (source instanceof String) {
            return bytes((String) source);
        } else if (source instanceof File) {
            return bytes((File) source);
        } else if (source instanceof InputStream) {
            return bytes((InputStream) source);
        } else {
            throw new IllegalStateException("Encountered unexpected byte source.  This is a bug - please notify " +
                    "the Shiro developer list asap (the isCompatible implementation does not reflect this " +
                    "method's implementation).");
        }
    }

    /**
     * 字节数组转换为 Hex 16进制字符串
     * @param byteArray
     * @return
     */
    private static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray = new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }
}
