package org.hotilsframework.core.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 数学工具测试类
 * @author hireny
 * @className MathUtilsTest
 * @create 2020-02-20 17:17
 */
public class MathsTest {

    /**
     * 加法测试
     */
    @Test
    public void addOfNumberTest() {
        BigDecimal bigDecimal = Maths.add(Integer.valueOf(23), Integer.valueOf(25));
        System.out.println(bigDecimal);
    }

    /**
     * 减法测试
     */
    @Test
    public void subtractOfNumberTest() {
        BigDecimal bigDecimal = Maths.subtract(41, 20.2078);
        System.out.println(bigDecimal);
    }
}
