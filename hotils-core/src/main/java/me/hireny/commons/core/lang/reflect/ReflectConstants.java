package me.hireny.commons.core.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/12 05:16
 */
public interface ReflectConstants {

    /**
     * 空的 Class 类数组
     */
    Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];

    /**
     * 空的 Method 方法数组
     */
    Method[] EMPTY_METHOD_ARRAY = new Method[0];

    /**
     * 空的 Field 字段数组
     */
    Field[] EMPTY_FIELD_ARRAY = new Field[0];

    /**
     * 空的 Object 对象数组
     */
    Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    //======================================================
    //  缓存发射中的方法和字段
    //======================================================


//    /**
//     * Cache for {@link Class#getDeclaredMethods()} plus equivalent default methods
//     * from Java 8 based interfaces, allowing for fast iteration.
//     */
//    private static final Map<Class<?>, Method[]> declaredMethodsCache = new ConcurrentReferenceHashMap<>(256);
//
//    /**
//     * Cache for {@link Class#getDeclaredFields()}, allowing for fast iteration.
//     */
//    private static final Map<Class<?>, Field[]> declaredFieldsCache = new ConcurrentReferenceHashMap<>(256);
    /**
     * Cache for {@link Class#getDeclaredMethods()} plus equivalent default methods
     * from Java 8 based interfaces, allowing for fast iteration.
     */
    Map<Class<?>, Method[]> declaredMethodsCache = new ConcurrentHashMap<>(256);

    /**
     * Cache for {@link Class#getDeclaredFields()}, allowing for fast iteration.
     */
    Map<Class<?>, Field[]> declaredFieldsCache = new ConcurrentHashMap<>(256);
}
