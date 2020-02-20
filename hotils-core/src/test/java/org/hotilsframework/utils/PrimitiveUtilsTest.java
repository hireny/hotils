package org.hotilsframework.utils;


import org.junit.Test;

/**
 * 原始类型工具类
 * @className PrimitivesTest
 * @auther hireny
 * @create 2020-02-17 18:42
 */
public class PrimitiveUtilsTest {
    /**
     * 获取所有基本类型测试
     */
    @Test
    public void allPrimitiveTypesTest() {
        System.out.println(PrimitiveUtils.allPrimitiveTypes().toString());
    }

    /**
     * 获取所有包装类型测试
     */
    @Test
    public void allWrapperTypesTest() {
        System.out.println(PrimitiveUtils.allWrapperTypes().toString());
    }

    /**
     * 基本类型获取包装类型测试
     */
    @Test
    public void wrapTest() {
        System.out.println(PrimitiveUtils.wrap(boolean.class));
        System.out.println(PrimitiveUtils.wrap(char.class));
        System.out.println(PrimitiveUtils.wrap(byte.class));
        System.out.println(PrimitiveUtils.wrap(short.class));
        System.out.println(PrimitiveUtils.wrap(int.class));
        System.out.println(PrimitiveUtils.wrap(long.class));
        System.out.println(PrimitiveUtils.wrap(float.class));
        System.out.println(PrimitiveUtils.wrap(double.class));
        System.out.println(PrimitiveUtils.wrap(void.class));
    }

    /**
     * 包装类型获取基本类型测试
     */
    @Test
    public void unwrapTest() {
        System.out.println(PrimitiveUtils.unwrap(Boolean.class));
        System.out.println(PrimitiveUtils.unwrap(Character.class));
        System.out.println(PrimitiveUtils.unwrap(Byte.class));
        System.out.println(PrimitiveUtils.unwrap(Short.class));
        System.out.println(PrimitiveUtils.unwrap(Integer.class));
        System.out.println(PrimitiveUtils.unwrap(Long.class));
        System.out.println(PrimitiveUtils.unwrap(Float.class));
        System.out.println(PrimitiveUtils.unwrap(Double.class));
        System.out.println(PrimitiveUtils.unwrap(Void.class));
    }
}
