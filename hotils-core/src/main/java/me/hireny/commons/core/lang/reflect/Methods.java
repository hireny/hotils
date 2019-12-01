package me.hireny.commons.core.lang.reflect;

import me.hireny.commons.utils.Assert;

import java.lang.reflect.Method;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/12 04:50
 */
public final class Methods {

    private Methods() {}


    /**
     * 通过反射技术找到方法
     * @param clazz
     * @param methodName
     * @return
     */
    public static Method findMethod(Class<?> clazz, String methodName) {
        return findMethod(clazz, methodName, ReflectConstants.EMPTY_CLASS_ARRAY);
    }
    /**
     * 使用反射技术找到方法
     * @param clazz         类
     * @param methodName    方法名称
     * @param paramTypes    参数类型
     * @return
     */
    public static Method findMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        Assert.checkNotNull(clazz, "Class must not be null");
        Assert.checkNotNull(methodName, "Method name must not be null");
        Class<?> searchType = clazz;
        while (searchType != null) {

        }
        return null;
    }

    /**
     *
     * @param clazz
     * @param defensive
     * @return
     */
    public static Method[] getDeclaredMethods(Class<?> clazz, boolean defensive) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        return declaredMethods;
    }
}
