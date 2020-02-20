package org.hotilsframework.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 字符串工具测试类
 * @author hireny
 * @className StringUtilsTest
 * @create 2020-02-20 15:32
 */
public class StringUtilsTest {
    /**
     * 字符串判空操作
     */
    @Test
    public void isEmptyTest() {
        assertEquals(StringUtils.isEmpty(null), true);
        System.out.println(StringUtils.isEmpty(null));  // true
        System.out.println(StringUtils.isEmpty(""));    // true
        System.out.println(StringUtils.isEmpty(" "));   // false
        System.out.println(StringUtils.isEmpty("bob")); // false
        System.out.println(StringUtils.isEmpty("  bob  ")); // false
    }

    /**
     * 字符串是否空白
     */
    @Test
    public void isBlankTest() {
        System.out.println(StringUtils.isBlank(null));  // true
        System.out.println(StringUtils.isBlank(""));    // true
        System.out.println(StringUtils.isBlank(" "));   // true
        System.out.println(StringUtils.isBlank("bob")); // false
        System.out.println(StringUtils.isBlank("  bob  ")); // false
    }

    /**
     * 是否是数字
     */
    @Test
    public void isNumber() {
        System.out.println(StringUtils.isNumber(null)); // false
        System.out.println(StringUtils.isNumber(""));   // false
        System.out.println(StringUtils.isNumber(" "));  // false
        System.out.println(StringUtils.isNumber("bob"));    // false
        System.out.println(StringUtils.isNumber("  bob   "));   // false
        System.out.println(StringUtils.isNumber("12349"));  // true
        System.out.println(StringUtils.isNumber("+12353")); // false
        System.out.println(StringUtils.isNumber("-1234324"));   // false
        System.out.println(StringUtils.isNumber("1.2345")); // false
        System.out.println(StringUtils.isNumber("0420203"));    // true
        System.out.println(StringUtils.isNumber("0x989FB"));    // false
        System.out.println(StringUtils.isNumber("0XABFD124"));  // false
        System.out.println(StringUtils.isNumber("\u0967\u0968\u0969")); // true
        System.out.println(StringUtils.isNumber("12 3"));   // false
        System.out.println(StringUtils.isNumber("ab2c"));   // false
        System.out.println(StringUtils.isNumber("12-3"));   // false
    }

    /**
     * 测试是否是空白符
     */
    @Test
    public void isWhitespaceTest() {
        System.out.println(StringUtils.isWhitespace(null)); // false
        System.out.println(StringUtils.isWhitespace(""));   // true
        System.out.println(StringUtils.isWhitespace("       "));    // true
        System.out.println(StringUtils.isWhitespace("abc"));    // false
        System.out.println(StringUtils.isWhitespace("ab2c"));   // false
        System.out.println(StringUtils.isWhitespace("ab-c"));   // false
        System.out.println(StringUtils.isWhitespace(" bcd   "));    // false
    }

    @Test
    public void isChineseTest() {
        System.out.println(StringUtils.isChinese(null));    // false
        System.out.println(StringUtils.isChinese(""));  // false
        System.out.println(StringUtils.isChinese("  "));    // false
        System.out.println(StringUtils.isChinese("abc"));   // false
        System.out.println(StringUtils.isChinese("汉字"));    // true
        System.out.println(StringUtils.isChinese(" 中文  ")); // true
        System.out.println(StringUtils.isChinese("测试 以下 ！"));   // true
    }

    /**
     * null -> ""
     */
    @Test
    public void nullToEmptyTest() {
        assertEquals(StringUtils.nullToEmpty(null), "");
        assertEquals(StringUtils.nullToEmpty(""), "");
        assertEquals(StringUtils.nullToEmpty("abcde"), "abcde");
        assertEquals(StringUtils.nullToEmpty("        "), "        ");  // 八个空格
    }

    /**
     * "" -> null
     */
    @Test
    public void emptyToNullTest() {
        assertEquals(StringUtils.emptyToNull(null), null);
        assertEquals(StringUtils.emptyToNull(""), null);
        assertEquals(StringUtils.emptyToNull("abcde"), "abcde");
        assertEquals(StringUtils.emptyToNull("    "), "    ");  // 四个空格
    }

    /**
     * 为空是的默认值
     */
    @Test
    public void defaultIfEmptyTest() {
        System.out.println(StringUtils.defaultIfEmpty(null, "空"));
        System.out.println(StringUtils.defaultIfEmpty("", "空"));
        System.out.println(StringUtils.defaultIfEmpty("  ", "空"));
        System.out.println(StringUtils.defaultIfEmpty("abcde", "空"));
        System.out.println(StringUtils.defaultIfEmpty("  abcde ", "空"));
    }

    /**
     * 取出开头和结尾的空格
     */
    @Test
    public void trimWhitespaceTest() {
        System.out.println(StringUtils.trimWhitespace(null));
        System.out.println(StringUtils.trimWhitespace(""));
        System.out.println(StringUtils.trimWhitespace(" abc"));
        System.out.println(StringUtils.trimWhitespace("abc   "));
        System.out.println(StringUtils.trimWhitespace("   abcdef   "));
        System.out.println(StringUtils.trimWhitespace(" hello, World ! "));
    }

    /**
     * 取出所有的空格
     */
    @Test
    public void trimAllWhitespaceTest() {
        System.out.println(StringUtils.trimAllWhitespace(null));
        System.out.println(StringUtils.trimAllWhitespace(""));
        System.out.println(StringUtils.trimAllWhitespace(" abc"));
        System.out.println(StringUtils.trimAllWhitespace("abc   "));
        System.out.println(StringUtils.trimAllWhitespace("   abcdef   "));
        System.out.println(StringUtils.trimAllWhitespace(" hello, World ! "));
    }

    /**
     * 首字母小写
     */
    @Test
    public void decapitalizeTest() {
        System.out.println(StringUtils.decapitalize("AbVDEfegwawwerw"));
    }

    /**
     * 首字母大写
     */
    @Test
    public void capitalizeTest() {
        System.out.println(StringUtils.capitalize("Sfsdfawfwfw"));
    }

    /**
     * 模式串中的%s处按序插入目标对象的测试
     */
    @Test
    public void lenientFormatTest() {
        String s = "abscd efldsfjie %s jfof %s woe";
        System.out.println(StringUtils.lenientFormat(s, "[abc]", "[dwq]"));
    }

    /**
     * 模式串中的{}处按序插入目标对象的测试
     */
    @Test
    public void formatTest() {
        String s = "abscd efldsfjie {} jfof{}woe";
        System.out.println(StringUtils.format(s, "[abc]", "[dwq]"));
    }

    /**
     * 判断两个字符串是否相等
     */
    @Test
    public void equalsTest() {
        System.out.println(StringUtils.equals("abcde", "abcde"));   // true
        System.out.println(StringUtils.equals("abcde", " abcde"));  // false
        System.out.println(StringUtils.equals(" abcde", "abcde ")); // false
        System.out.println(StringUtils.equals(new String("abcde"), new String("abcde")));   // true
    }
}
