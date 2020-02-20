package org.hotilsframework.utils;

import org.junit.Test;

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
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("bob"));
        System.out.println(StringUtils.isEmpty("  bob  "));
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
}
