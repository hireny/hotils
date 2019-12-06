package me.hireny.commons.codec;

import java.io.File;
import java.io.InputStream;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/13 19:46
 */
public interface ByteSource {

    /**
     * Returns the wrapped byte array.
     *
     * @return the wrapped byte array.
     */
    byte[] getBytes();

    /**
     * 返回字节数组的格式化字符串表示形式
     * @return
     */
    String toHex();

    /**
     * 返回字节数组的Base64的格式化字符串表示形式
     * @return
     */
    String toBase64();

    /**
     * 判断字节资源是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * Utility class that can construct ByteSource instances.  This is slightly nicer than needing to know the
     * {@code ByteSource} implementation class to use.
     *
     * @since 1.2
     */
    public static final class Utils {

        /**
         * Returns a new {@code ByteSource} instance representing the specified byte array.
         *
         * @param bytes the bytes to represent as a {@code ByteSource} instance.
         * @return a new {@code ByteSource} instance representing the specified byte array.
         */
        public static ByteSource bytes(byte[] bytes) {
            return null;
        }

        /**
         * Returns a new {@code ByteSource} instance representing the specified character array's bytes.  The byte
         * array is obtained assuming {@code UTF-8} encoding.
         *
         * @param chars the character array to represent as a {@code ByteSource} instance.
         * @return a new {@code ByteSource} instance representing the specified character array's bytes.
         */
        public static ByteSource bytes(char[] chars) {
            return null;
        }

        /**
         * Returns a new {@code ByteSource} instance representing the specified string's bytes.  The byte
         * array is obtained assuming {@code UTF-8} encoding.
         *
         * @param string the string to represent as a {@code ByteSource} instance.
         * @return a new {@code ByteSource} instance representing the specified string's bytes.
         */
        public static ByteSource bytes(String string) {
            return null;
        }

        /**
         * Returns a new {@code ByteSource} instance representing the specified ByteSource.
         *
         * @param source the ByteSource to represent as a new {@code ByteSource} instance.
         * @return a new {@code ByteSource} instance representing the specified ByteSource.
         */
        public static ByteSource bytes(ByteSource source) {
            return null;
        }

        /**
         * Returns a new {@code ByteSource} instance representing the specified File's bytes.
         *
         * @param file the file to represent as a {@code ByteSource} instance.
         * @return a new {@code ByteSource} instance representing the specified File's bytes.
         */
        public static ByteSource bytes(File file) {
            return null;
        }

        /**
         * Returns a new {@code ByteSource} instance representing the specified InputStream's bytes.
         *
         * @param stream the InputStream to represent as a {@code ByteSource} instance.
         * @return a new {@code ByteSource} instance representing the specified InputStream's bytes.
         */
        public static ByteSource bytes(InputStream stream) {
            return null;
        }

        /**
         * 判断资源是否可以转换为ByteSource
         * @param source
         * @return
         */
        public static boolean isCompatible(Object source) {
            return false;
        }

        /**
         * 将资源转换为ByteSource
         * @param source
         * @return
         * @throws IllegalArgumentException
         */
        public static ByteSource bytes(Object source) throws IllegalArgumentException {
            if (source == null) {
                return null;
            }
            if (!isCompatible(source)) {
                String msg = "Unable to heuristically acquire bytes for object of type [" +
                        source.getClass().getName() + "].  If this type is indeed a byte-backed data type, you might " +
                        "want to write your own ByteSource implementation to extract its bytes explicitly.";
                throw new IllegalArgumentException(msg);
            }
            if (source instanceof byte[]) {
                return bytes((byte[]) source);
            } else if (source instanceof ByteSource) {
                return (ByteSource) source;
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
}
