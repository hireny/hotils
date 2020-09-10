package org.hotilsframework.lang;

import org.hotilsframework.lang.NumberUtils;
import org.junit.Test;

/**
 * 数字工具类测试
 * @ClassName: NumberUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-02-16 23:51
 * @Version: 1.0
 */
public class NumberUtilsTest {

    /**
     * 测试是否是16进制的数字
     */
    @Test
    public void isHexNumberTest() {
        String test1 = "0x23451";
        String test2 = "050000";
        String test3 = "0xfsfwfwf";
        System.out.println(NumberUtils.isHexNumber(test1));
        System.out.println(NumberUtils.isHexNumber(test2));
        System.out.println(NumberUtils.isHexNumber(test3));
    }

    /**
     * 是否是有效的数字的测试方法
     */
    @Test
    public void isCreatableTest() {
        String test1 = "0x23451";
        String test2 = "050000";
        String test3 = "-24343242";
        String test4 = "-232E8882";
        String test5 = "+87888321";
        String test6 = "0xoqewqa";
        String test7 = "023sq";
        String test8 = "23097";
        System.out.println(NumberUtils.isCreatable(test1));
        System.out.println(NumberUtils.isCreatable(test2));
        System.out.println(NumberUtils.isCreatable(test3));
        System.out.println(NumberUtils.isCreatable(test4));
        System.out.println(NumberUtils.isCreatable(test5));
        System.out.println(NumberUtils.isCreatable(test6));
        System.out.println(NumberUtils.isCreatable(test7));
        System.out.println(NumberUtils.isCreatable(test8));
    }
}
