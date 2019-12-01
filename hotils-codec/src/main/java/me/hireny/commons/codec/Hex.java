package me.hireny.commons.codec;

/**
 * Hex
 * Hex 16进制
 * @Author: hireny
 * @Date: Create in 2019/10/13 19:50
 */
public class Hex {

    /**
     * Used to build output as Hex
     * 用于生成16进制的输出
     */
    private static final char[] DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

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
     * @param c
     * @param index
     * @return
     */
    protected static int toDigit(char c, int index) {
        int digit = Character.digit(c, 16);
        if (digit == -1) {
            // 非法的16进制字符
            throw new IllegalArgumentException("Illegal hexadecimal character " + c + " at index " + index);
        }
        return digit;
    }
}
