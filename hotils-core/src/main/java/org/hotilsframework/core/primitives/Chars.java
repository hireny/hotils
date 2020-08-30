package org.hotilsframework.core.primitives;

import org.hotilsframework.lang.Symbol;
import org.hotilsframework.lang.Assert;

/**
 * 字符
 * @className Chars
 * @author hireny
 * @date Created in 2020-02-03 12:44
 * @version 1.0
 */
public final class Chars {

    private char value;

    private Chars() {}

    private Chars(char value) {
        this.value = value;
    }

    private Chars(Character value) {
        this.value = value;
    }

    public char getValue() {
        return (char) value;
    }

    /**
     * 将字符转换为byte数组
     * @return
     */
    public byte[] toBytes() {
        return toByteArray(value);
    }

    /**
     * 检查是否为ASCII字符，ASCII字符位于0~127之间
     * @return
     */
    public boolean isAscii() {
        return value < 128;
    }

    /**
     * 检查是否为可见ASCII字符，可见字符位于32~126之间
     * @return
     */
    public boolean isAsciiPrintable() {
        return value >= 32 && value < 127;
    }

    /**
     * 检查是否为ASCII控制符（不可见字符），控制符位于0~31和127
     * @return
     */
    public boolean isAsciiControl() {
        return value < 32 || value == 127;
    }

    /**
     * 判断是否为字母（包括大写字母和小写字母）
     * 字母包括A~Z和a~z
     * @return
     */
    public boolean isLetter() {
        return isLetterUpper() || isLetterLower();
    }

    /**
     * 判断是否为大写字母，大写字母包括A~Z
     * @return
     */
    public boolean isLetterUpper() {
        return value >= 'A' && value <= 'Z';
    }

    /**
     * 判断是否为小写字母，小写字母包括a~z
     * @return
     */
    public boolean isLetterLower() {
        return value >= 'a' && value <= 'z';
    }

    /**
     * 检查是否为数字字符，数字字符包括0~9
     * @return
     */
    public boolean isNumber() {
        return value >= '0' && value <= '9';
    }

    /**
     * 检查是否为16进制规范的字符，判断是否为如下字符：
     * <pre>
     *     1. 0~9
     *     2. a~f
     *     3. A~F
     * </pre>
     * @return
     */
    public boolean isHex() {
        return isNumber() || (value >= 'a' && value <= 'f') || (value >= 'A' && value <= 'F');
    }

    /**
     * 检查是否为字符或数字，包括A~Z、a~z、0~9
     * @return
     */
    public boolean isLetterOrNumber() {
        return isLetter() || isNumber();
    }

    /**
     * 是否空白符 <br>
     *
     * 空白符包括空格、制表符、全角空格和不间断空格
     *
     * @return
     */
    public boolean isBlankChar() {
        return Character.isWhitespace(value) || Character.isSpaceChar(value) || value == '\ufeff' || value == '\u202a';
    }

    /**
     * 是否为Windows或者Linux（Unix）文件分隔符<br>
     * Windows平台下分隔符为\，Linux（Unix）为/
     *
     * @return 是否为Windows或者Linux（Unix）文件分隔符
     * @since 4.1.11
     */
    public boolean isFileSeparator() {
        return Symbol.SLASH == value || Symbol.BACKSLASH == value;
    }

    /**
     * 当忽略大小写时，比较是否相等
     * @param o
     * @return
     */
    public boolean equalsIgnoreCase(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (isChar(o.getClass())) {
            char oc = (char) o;
            return value == oc;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        return Character.toLowerCase(this.value) == Character.toLowerCase(((Chars) o).value);
    }

    /**
     * 比较是否相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (isChar(o.getClass())) {
            char oc = (char) o;
            return value == oc;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Chars chars = (Chars) o;

        return value == chars.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }


    //=========================================
    // 静态方法
    //=========================================

    public static final int BYTES = Character.SIZE / Byte.SIZE;

    public static Chars of(char value) {
        return new Chars(value);
    }

    public static Chars of(Character value) {
        return new Chars(value);
    }

    /**
     * 将字符转换为byte数组
     * @param value
     * @return
     */
    public static byte[] toByteArray(char value) {
        return new byte[] {(byte) (value >> 8), (byte) value};
    }


    /**
     * 将byte数组转换为字符
     * @param bytes
     * @return
     */
    public static char fromByteArray(byte[] bytes) {
        Assert.state(bytes.length >= BYTES, "array to small: %s < %s", bytes.length, BYTES);
        return fromBytes(bytes[0], bytes[1]);
    }

    /**
     * 将byte数组转换为字符
     * @param b1
     * @param b2
     * @return
     */
    public static char fromBytes(byte b1, byte b2) {
        return  (char) ((b1 << 8) | (b2 & 0xFF));
    }

    /**
     * 检查给定对象对应的类是否为字符类，字符类包括：
     *
     * <pre>
     *     char.class
     *     Character.class
     * </pre>
     * @return
     */
    public static boolean isChar(Object o) {
        return o instanceof Character || o.getClass() == char.class;
    }

    /**
     * 检查给定类名是否为字符类，字符类包括：
     *
     * <pre>
     *     char.class
     *     Character.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isChar(Class<?> clazz) {
        return clazz == char.class || clazz == Character.class;
    }
}
