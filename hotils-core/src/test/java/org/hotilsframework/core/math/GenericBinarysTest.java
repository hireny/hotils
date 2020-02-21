package org.hotilsframework.core.math;

import org.junit.Test;

/**
 * 进制转换测试
 * @author hireny
 * @className GenericBinarysTest
 * @create 2020-02-21 22:31
 */
public class GenericBinarysTest {

    /**
     * 进制转换测试
     */
    @Test
    public void transfromTest() {
        String s = "1F";
        System.out.println(GenericBinarys.transfrom(s, 16, 10));
    }
}
