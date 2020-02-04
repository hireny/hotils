package org.hotilsframework.lang;

import java.lang.reflect.Field;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:30
 */
public final class Enums {
    private Enums() {}

    public static Field getField(Enum<?> enumValue) {
        Class<?> clazz = enumValue.getDeclaringClass();
        try {
            return clazz.getDeclaredField(enumValue.name());
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * 查询给定的枚举常量数组中是否存在给定名称的常量
     * @param enumValues
     * @param constant
     * @return
     */
    public static boolean contains(Enum<?>[] enumValues, String constant) {
        return contains(enumValues, constant, false);
    }

    /**
     * 查询给定的枚举常量数组中是否存在给定名称的常量
     * @param enumValues
     * @param constant
     * @param caseSensitive     区分大小写
     * @return
     */
    public static boolean contains(Enum<?>[] enumValues, String constant, boolean caseSensitive) {
        for (Enum<?> candidate : enumValues) {
            if (caseSensitive ? candidate.toString().equals(constant) :
                    candidate.toString().equalsIgnoreCase(constant)) {
                return true;
            }
        }
        return false;
    }
}
