package org.hotilsframework.utils;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 数字工具类测试
 * @ClassName: NumberUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-02-16 23:51
 * @Version: 1.0
 */
public class NumberUtilsTest {

    /**
     * 加法测试
     */
    @Test
    public void addOfNumberTest() {
        BigDecimal bigDecimal = NumberUtils.add(Integer.valueOf(23), Integer.valueOf(25));
        System.out.println(bigDecimal);
    }

    @Test
    public void subtractOfNumberTest() {
        BigDecimal bigDecimal = NumberUtils.subtract(41, 20.2078);
        System.out.println(bigDecimal);
    }
}
