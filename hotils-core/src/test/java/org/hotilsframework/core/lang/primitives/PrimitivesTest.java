package org.hotilsframework.core.lang.primitives;

import org.hotilsframework.utils.ObjectUtils;
import org.junit.Test;

/**
 * 原始类型工具类
 * @className PrimitivesTest
 * @auther hireny
 * @create 2020-02-17 18:42
 */
public class PrimitivesTest {

    /**
     * 测试是否是boolean类型
     */
    @Test
    public void isBooleanTest() {
        boolean t = true;
        Boolean tt = false;
        String ttt = "true";
        int tttt = 2;
        System.out.println(Primitives.isBoolean(ObjectUtils.getClass(t)));
        System.out.println(Primitives.isBoolean(tt.getClass()));
        System.out.println(Primitives.isBoolean(ttt.getClass()));
        System.out.println(Primitives.isBoolean(ObjectUtils.getClass(tttt)));
    }
}
