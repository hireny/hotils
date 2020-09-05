package org.hotilsframework.lang.reflects;

import org.hotilsframework.lang.ArrayUtils;
import org.hotilsframework.lang.reflects.ModifierType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 修饰符工具类
 * @ClassName: ModifierUtils
 * @Author: hireny
 * @Date: Created in 2020-02-03 20:53
 * @Version: 1.0
 */
public final class ModifierUtils {
    private ModifierUtils() {}

    /**
     * 是否同时存在一个或多个修饰符（可能有多个修饰符，如果有指定的修饰符则返回true）
     * @param clazz             类
     * @param modifierTypes     修饰符枚举
     * @return                  是否有指定修饰符，如果有返回true，否则false，如果提供参数为null返回false
     */
    public static boolean hasModifier(Class<?> clazz, ModifierType... modifierTypes) {
        if (null == clazz || ArrayUtils.isEmpty(modifierTypes)) {
            return false;
        }
        return 0 != (clazz.getModifiers() & modifiersToInt(modifierTypes));
    }

    /**
     * 是否同时存在一个或多个修饰符（可能有多个修饰符，如果有指定的修饰符则返回true）
     *
     * @param constructor 构造方法
     * @param modifierTypes 修饰符枚举
     * @return 是否有指定修饰符，如果有返回true，否则false，如果提供参数为null返回false
     */
    public static boolean hasModifier(Constructor<?> constructor, ModifierType... modifierTypes) {
        if (null == constructor || ArrayUtils.isEmpty(modifierTypes)) {
            return false;
        }
        return 0 != (constructor.getModifiers() & modifiersToInt(modifierTypes));
    }

    /**
     * 是否同时存在一个或多个修饰符（可能有多个修饰符，如果有指定的修饰符则返回true）
     *
     * @param method 方法
     * @param modifierTypes 修饰符枚举
     * @return 是否有指定修饰符，如果有返回true，否则false，如果提供参数为null返回false
     */
    public static boolean hasModifier(Method method, ModifierType... modifierTypes) {
        if (null == method || ArrayUtils.isEmpty(modifierTypes)) {
            return false;
        }
        return 0 != (method.getModifiers() & modifiersToInt(modifierTypes));
    }

    /**
     * 是否同时存在一个或多个修饰符（可能有多个修饰符，如果有指定的修饰符则返回true）
     *
     * @param field 字段
     * @param modifierTypes 修饰符枚举
     * @return 是否有指定修饰符，如果有返回true，否则false，如果提供参数为null返回false
     */
    public static boolean hasModifier(Field field, ModifierType... modifierTypes) {
        if (null == field || ArrayUtils.isEmpty(modifierTypes)) {
            return false;
        }
        return 0 != (field.getModifiers() & modifiersToInt(modifierTypes));
    }

    //============================================
    //  对象判断标识符
    //============================================

    /**
     * 字段是否是 public 修饰符
     * @param field
     * @return
     */
    public static boolean isPublic(Field field) {
        return hasModifier(field, ModifierType.PUBLIC);
    }

    /**
     * 方法是否是 public 修饰符
     * @param method
     * @return
     */
    public static boolean isPublic(Method method) {
        return hasModifier(method, ModifierType.PUBLIC);
    }

    /**
     * 类是否是 public 修饰符
     * @param clazz
     * @return
     */
    public static boolean isPublic(Class<?> clazz) {
        return hasModifier(clazz, ModifierType.PUBLIC);
    }

    /**
     * 构造器是否是 public 修饰符
     * @param constructor
     * @return
     */
    public static boolean isPublic(Constructor<?> constructor) {
        return hasModifier(constructor, ModifierType.PUBLIC);
    }

    public static boolean isProtected(Field field) {
        return hasModifier(field, ModifierType.PROTECTED);
    }

    public static boolean isProtected(Method method) {
        return hasModifier(method, ModifierType.PROTECTED);
    }

    public static boolean isProtected(Constructor<?> constructor) {
        return hasModifier(constructor, ModifierType.PROTECTED);
    }

    public static boolean isProtected(Class<?> clazz) {
        return hasModifier(clazz, ModifierType.PROTECTED);
    }

    public static boolean isPrivate(Field field) {
        return hasModifier(field, ModifierType.PRIVATE);
    }

    public static boolean isPrivate(Method method) {
        return hasModifier(method, ModifierType.PRIVATE);
    }

    public static boolean isPrivate(Constructor<?> constructor) {
        return hasModifier(constructor, ModifierType.PRIVATE);
    }

    public static boolean isPrivate(Class<?> clazz) {
        return hasModifier(clazz, ModifierType.PRIVATE);
    }

    /**
     * 字段是否是 final 修饰符
     * @param field
     * @return
     */
    public static boolean isFinal(Field field) {
        return hasModifier(field, ModifierType.FINAL);
    }

    /**
     * 方法是否是 final 修饰符
     * @param method
     * @return
     */
    public static boolean isFinal(Method method) {
        return hasModifier(method, ModifierType.FINAL);
    }

    /**
     * 类是否是 final 修饰符
     * @param clazz
     * @return
     */
    public static boolean isFinal(Class<?> clazz) {
        return hasModifier(clazz, ModifierType.FINAL);
    }


    /**
     * 是否是static字段
     *
     * @param field 字段
     * @return 是否是static
     */
    public static boolean isStatic(Field field) {
        return hasModifier(field, ModifierType.STATIC);
    }

    /**
     * 是否是static方法
     *
     * @param method 方法
     * @return 是否是static
     */
    public static boolean isStatic(Method method) {
        return hasModifier(method, ModifierType.STATIC);
    }

    /**
     * 是否是static类
     *
     * @param clazz 类
     * @return 是否是static
     */
    public static boolean isStatic(Class<?> clazz) {
        return hasModifier(clazz, ModifierType.STATIC);
    }


    public static boolean isPublicStaticFinal(Field field) {
        int modifiers = field.getModifiers();
        return (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers));
    }

    /**
     * 多个修饰符做 "与" 操作，表示同时存在多个修饰符
     * @param modifierTypes 修饰符列表，元素不能为空
     * @return  "与" 之后的修饰符
     */
    private static int modifiersToInt(ModifierType... modifierTypes) {
        int modifier = modifierTypes[0].getValue();
        int length = modifierTypes.length;
        for (int i = 1; i < length; i ++) {
            modifier &= modifierTypes[i].getValue();
        }
        return modifier;
    }
}
