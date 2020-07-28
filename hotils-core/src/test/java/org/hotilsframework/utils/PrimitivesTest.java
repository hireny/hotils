package org.hotilsframework.utils;


import org.hotilsframework.core.primitives.Primitives;
import org.junit.Test;

/**
 * 原始类型工具类
 * @className PrimitivesTest
 * @auther hireny
 * @create 2020-02-17 18:42
 */
public class PrimitivesTest {
    /**
     * 获取所有基本类型测试
     */
    @Test
    public void allPrimitiveTypesTest() {
        System.out.println(Primitives.allPrimitiveTypes().toString());
    }

    /**
     * 获取所有包装类型测试
     */
    @Test
    public void allWrapperTypesTest() {
        System.out.println(Primitives.allWrapperTypes().toString());
    }

    /**
     * 基本类型获取包装类型测试
     */
    @Test
    public void wrapTest() {
        System.out.println(Primitives.wrap(boolean.class));
        System.out.println(Primitives.wrap(char.class));
        System.out.println(Primitives.wrap(byte.class));
        System.out.println(Primitives.wrap(short.class));
        System.out.println(Primitives.wrap(int.class));
        System.out.println(Primitives.wrap(long.class));
        System.out.println(Primitives.wrap(float.class));
        System.out.println(Primitives.wrap(double.class));
        System.out.println(Primitives.wrap(void.class));
    }

    /**
     * 包装类型获取基本类型测试
     */
    @Test
    public void unwrapTest() {
        System.out.println(Primitives.unwrap(Boolean.class));
        System.out.println(Primitives.unwrap(Character.class));
        System.out.println(Primitives.unwrap(Byte.class));
        System.out.println(Primitives.unwrap(Short.class));
        System.out.println(Primitives.unwrap(Integer.class));
        System.out.println(Primitives.unwrap(Long.class));
        System.out.println(Primitives.unwrap(Float.class));
        System.out.println(Primitives.unwrap(Double.class));
        System.out.println(Primitives.unwrap(Void.class));
    }
}
