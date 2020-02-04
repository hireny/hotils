package org.hotilsframework.lang.primitives;

import org.hotilsframework.lang.Symbol;

/**
 * 字符
 * @ClassName: Chars
 * @Author: hireny
 * @Date: Created in 2020-02-03 12:44
 * @Version: 1.0
 */
public final class Chars {

    private int c;

    private Chars() {}

    private Chars(char c) {
        this.c = c;
    }

    private Chars(int c) {
        this.c = c;
    }

    public char getC() {
        return (char) c;
    }

    /**
     * 检查是否为ASCII字符，ASCII字符位于0~127之间
     * @return
     */
    public boolean isAscii() {
        return c < 128;
    }

    /**
     * 检查是否为可见ASCII字符，可见字符位于32~126之间
     * @return
     */
    public boolean isAsciiPrintable() {
        return c >= 32 && c < 127;
    }

    /**
     * 检查是否为ASCII控制符（不可见字符），控制符位于0~31和127
     * @return
     */
    public boolean isAsciiControl() {
        return c < 32 || c == 127;
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
        return c >= 'A' && c <= 'Z';
    }

    /**
     * 判断是否为小写字母，小写字母包括a~z
     * @return
     */
    public boolean isLetterLower() {
        return c >= 'a' && c <= 'z';
    }

    /**
     * 检查是否为数字字符，数字字符包括0~9
     * @return
     */
    public boolean isNumber() {
        return c >= '0' && c <= '9';
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
        return isNumber() || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
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
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == '\ufeff' || c == '\u202a';
    }

    /**
     * 是否为Windows或者Linux（Unix）文件分隔符<br>
     * Windows平台下分隔符为\，Linux（Unix）为/
     *
     * @return 是否为Windows或者Linux（Unix）文件分隔符
     * @since 4.1.11
     */
    public boolean isFileSeparator() {
        return Symbol.SLASH == c || Symbol.BACKSLASH == c;
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
        if (isCharClass(o.getClass())) {
            char oc = (char) o;
            return c == oc;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        return Character.toLowerCase(this.c) == Character.toLowerCase(((Chars) o).c);
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
        if (isCharClass(o.getClass())) {
            char oc = (char) o;
            return c == oc;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Chars chars = (Chars) o;

        return c == chars.c;
    }

    @Override
    public int hashCode() {
        return c;
    }

    @Override
    public String toString() {
        return String.valueOf(this.c);
    }


    //=========================================
    // 静态方法
    //=========================================

    public static Chars of(char c) {
        return new Chars(c);
    }

    public static Chars of(Character c) {
        return new Chars(c);
    }

    public static Chars of(int c) {
        return new Chars(c);
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
    public static boolean isCharClass(Class<?> clazz) {
        return clazz == char.class || clazz == Character.class;
    }
}
