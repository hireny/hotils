package org.hotilsframework.codec;

/**
 * 字节转换
 * @Author: hireny
 * @Date: Create in 2019/10/13 19:50
 */
public class Hex {

    /**
     * Used to build output as Hex
     * 用于生成16进制的输出
     */
    private static final char[] DIGITS_LOWER = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    private static final char[] DIGITS_UPPER = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    /**
     * 16禁止转byte数组
     * @param data  16进制字符串
     * @return  byte数组
     * @throws Exception    转换失败的异常
     */
    public static byte[] hexToBytes(final String data) throws Exception {
        final int len = data.length();

        int num = 0x01;
        if ((len & num) != 0) {
            throw new Exception("Odd number of characters.");
        }
        final byte[] out = new byte[len >> 1];

        // tow characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data.charAt(j), j) << 4;
            j++;
            f = f | toDigit(data.charAt(j), j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

    /**
     * bytes数组转16进制String
     * @param data  bytes数组
     * @return  转换结果
     */
    public static String bytesToHex(final byte[] data) {
        return bytesToHex(data, true);
    }

    /**
     * bytes数组转16进制String
     * @param data          bytes数组
     * @param toLowerCase   是否小写
     * @return  转换结果
     */
    public static String bytesToHex(final byte[] data, final boolean toLowerCase) {
        return bytesToHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * bytes数组转16进制String
     * @param data      bytes数组
     * @param toDigits  DIGITS_LOWER或DIGITS_UPPER
     * @return  转换结果
     */
    private static String bytesToHex(final byte[] data, final char[] toDigits) {
        final int len = data.length;
        final char[] out = new char[len << 1];
        // tow characters form the hex value.
        for (int i = 0, j = 0; i < len; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return new String(out);
    }

    /**
     * 将字节数组编码为字符数组
     * @param data
     * @return
     */
    public static char[] encode(byte[] data) {
        return null;
    }

    /**
     * 将字符数组解码为字节数组
     * @param data
     * @return
     */
    public static byte[] decode(char[] data) {
        return null;
    }

    /**
     * Converts a hexadecimal character to an integer.
     * 将16进制数转换为整数
     * @param c     16进制
     * @param index 索引
     * @return      转换结果
     * @throws IllegalArgumentException 转换失败异常
     */
    protected static int toDigit(char c, int index) throws IllegalArgumentException {
        int digit = Character.digit(c, 16);
        if (digit == -1) {
            // 非法的16进制字符
            throw new IllegalArgumentException("Illegal hexadecimal character " + c + " at index " + index);
        }
        return digit;
    }
}
