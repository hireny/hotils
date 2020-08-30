package org.hotilsframework.lang;

import org.hotilsframework.core.primitives.Primitives;

import java.io.Closeable;
import java.io.Externalizable;
import java.io.Serializable;
import java.util.*;
import java.util.Optional;

/**
 * 类工具类
 * @ClassName: ClassUtils
 * @Author: hireny
 * @Date: Created in 2020-01-15 13:58
 * @Version: 1.0
 */
public final class ClassUtils {

    private ClassUtils() {}

    /** Suffix for array class names: {@code "[]"}. */
    public static final String ARRAY_SUFFIX = "[]";

    /** Prefix for internal array class names: {@code "["}. */
    private static final String INTERNAL_ARRAY_PREFIX = "[";

    /** Prefix for internal non-primitive array class names: {@code "[L"}. */
    private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";

    /** The package separator character: {@code '.'}. */
    private static final char PACKAGE_SEPARATOR = '.';

    /** The path separator character: {@code '/'}. */
    private static final char PATH_SEPARATOR = '/';

    /** The inner class separator character: {@code '$'}. */
    private static final char INNER_CLASS_SEPARATOR = '$';

    /** The CGLIB class separator: {@code "$$"}. */
    public static final String CGLIB_CLASS_SEPARATOR = "$$";

    /** The ".class" file suffix. */
    public static final String CLASS_FILE_SUFFIX = ".class";

    /**
     * 常用的类型缓存，都是Java中的类型，不包括基本类型，
     * 例如：boolean、char、byte、short、int、long、float、double等
     */
    private static final Map<String, Class<?>> commonClassCache;

    /**
     * Common Java language interfaces which are supposed to be ignored
     * when searching for 'primary' user-level interfaces.
     * Java语言的公共接口的类型缓存
     */
    private static final Set<Class<?>> javaLanguageInterfaces;

    static {
        Map<String, Class<?>> tempCommonClassCache = new LinkedHashMap<>(16);

        for (Class<?> wrapperType : Primitives.allWrapperTypes()) {
            // 注册常用类型
            registerCommonClasses(tempCommonClassCache, wrapperType);
        }

        // 注册常用类型
        registerCommonClasses(tempCommonClassCache, Boolean[].class, Byte[].class, Character[].class, Double[].class,
                Float[].class, Integer[].class, Long[].class, Short[].class);
        registerCommonClasses(tempCommonClassCache, Number.class, Number[].class, String.class, String[].class,
                Class.class, Class[].class, Object.class, Object[].class);
        registerCommonClasses(tempCommonClassCache, Throwable.class, Exception.class, RuntimeException.class,
                Error.class, StackTraceElement.class, StackTraceElement[].class);
        registerCommonClasses(tempCommonClassCache, Enum.class, Iterable.class, Iterator.class, Enumeration.class,
                Collection.class, List.class, Set.class, Map.class, Map.Entry.class, Optional.class);

        // Java语言公共接口的数组
        Class<?>[] javaLanguageInterfaceArray = {Serializable.class, Externalizable.class,
                Closeable.class, AutoCloseable.class, Cloneable.class, Comparable.class};
        registerCommonClasses(tempCommonClassCache, javaLanguageInterfaceArray);
        javaLanguageInterfaces = new HashSet<>(Arrays.asList(javaLanguageInterfaceArray));

        commonClassCache = Collections.unmodifiableMap(tempCommonClassCache);
    }

    /**
     * 注册常用的类型
     * @param commonClassCache
     * @param commonClasses
     */
    private static void registerCommonClasses(Map<String, Class<?>> commonClassCache, Class<?>... commonClasses) {
        for (Class<?> commonClass : commonClasses) {
            commonClassCache.put(commonClass.getName(), commonClass);
        }
    }

    /**
     * 根据名称获取类
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    public static Class<?> forName(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    /**
     * Check whether the given class is visible in the given ClassLoader.
     * @param clazz the class to check (typically an interface)
     * @param classLoader the ClassLoader to check against
     * (may be {@code null} in which case this method will always return {@code true})
     */
    public static boolean isVisible(Class<?> clazz, ClassLoader classLoader) {
        if (classLoader == null) {
            return true;
        }
        try {
            if (clazz.getClassLoader() == classLoader) {
                return true;
            }
        }
        catch (SecurityException ex) {
            // Fall through to loadable check below
        }

        // Visible if same Class can be loaded from given ClassLoader
        return isLoadable(clazz, classLoader);
    }

    /**
     * Check whether the given class is loadable in the given ClassLoader.
     * @param clazz the class to check (typically an interface)
     * @param classLoader the ClassLoader to check against
     * @since 5.0.6
     */
    private static boolean isLoadable(Class<?> clazz, ClassLoader classLoader) {
        try {
            return (clazz == classLoader.loadClass(clazz.getName()));
            // Else: different class with same name found
        }
        catch (ClassNotFoundException ex) {
            // No corresponding class found at all
            return false;
        }
    }

    /**
     * 检测是否可以将sourceType代表的类型转换到targetType代表的类型
     * @param sourceType        要转换的类型
     * @param targetType        目标的类型
     * @return
     */
    public static boolean isAssignableFrom(Class<?> sourceType, Class<?> targetType) {
        Assert.notNull(sourceType, "Left-hand side type must not be null");
        Assert.notNull(targetType, "Right-hand side type must not be null");
        if (sourceType.isAssignableFrom(targetType)) {
            return true;
        }
        if (sourceType.isPrimitive()) {
            // 判断类型是否是基本类型，例如：int，float

            // 如果类型是基本类型，则我们要从缓存包装对应基本的映射集合中，使用targetType，从中获取对应的基本类型
            Class<?> resolvedPrimitive = Primitives.getWrapperToPrimitiveType().get(targetType);
            if (sourceType == resolvedPrimitive) {
                return true;
            }
        } else {
            // 如果不是基本类型，就是包装类型，例如：Integer，Float

            // 如果sourceType是不是基本类型，则我们要从缓存基本对应包装的映射集合中，使用targetType，从中获取对应的包装类型
            Class<?> resolvedWrapper = Primitives.getPrimitiveToWrapperType().get(targetType);
            if (resolvedWrapper != null && sourceType.isAssignableFrom(resolvedWrapper)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 比较判断sourceType和targetType两数组，如果sourceType中所有的类都与targetType对应位置的类相同，或者是其父类或接口，则返回 true
     *
     * @param sourceTypes       来源类数组
     * @param targetTypes       目标类数组
     * @return                  是否相同、父类或接口
     */
    public static boolean isAssignableFrom(Class<?>[] sourceTypes, Class<?>[] targetTypes) {
        if (ArrayUtils.isEmpty(sourceTypes) && ArrayUtils.isEmpty(targetTypes)) {
            return true;
        }
        if (null == sourceTypes || null == targetTypes) {
            // 任何一个为null不相等（之前已判断两个都为null的情况）
            return false;
        }
        if (sourceTypes.length != targetTypes.length) {
            return false;
        }

        Class<?> sourceType;
        Class<?> targetType;
        for (int i = 0; i < sourceTypes.length; i++) {
            sourceType = sourceTypes[i];
            targetType = targetTypes[i];
            if ((Primitives.isPrimitiveType(sourceType) || Primitives.isWrapperType(sourceType))
                    && (Primitives.isPrimitiveType(targetType) || Primitives.isWrapperType(targetType))) {
                // 原始类型和包装类型存在不一致情况
                if (Primitives.unwrap(sourceType) != Primitives.unwrap(targetType)) {
                    return false;
                }
            } else if (!sourceType.isAssignableFrom(targetType)) {
                return false;
            }
        }
        return true;
    }
}
