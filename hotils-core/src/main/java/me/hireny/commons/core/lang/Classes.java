package me.hireny.commons.core.lang;

import me.hireny.commons.utils.Assert;

import java.io.Closeable;
import java.io.Externalizable;
import java.io.Serializable;
import java.util.*;

/**
 * Classes
 * 对Class类进行增强
 * @Author: hireny
 * @Date: Create in 2019/10/03 22:29
 */
public class Classes {
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
     * Map with primitive wrapper type as key and corresponding primitive
     * type as value, for example: Integer.class -> int.class.
     * 包装类型对应的基本类型
     */
    private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new IdentityHashMap<>(8);

    /**
     * Map with primitive type as key and corresponding wrapper
     * type as value, for example: int.class -> Integer.class.
     * 基本类型对应的包装类型
     */
    private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new IdentityHashMap<>(8);

    /**
     * Map with primitive type name as key and corresponding primitive
     * type as value, for example: "int" -> "int.class".
     * 基本类型的映射关系的缓存
     */
    private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap<>(32);

    /**
     * 常用的类型缓存
     */
    private static final Map<String, Class<?>> commonClassCache = new HashMap<>();

    /**
     * Common Java language interfaces which are supposed to be ignored
     * when searching for 'primary' user-level interfaces.
     * Java语言的公共接口的类型缓存
     */
    private static final Set<Class<?>> javaLanguageInterfaces;

    static {
        primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
        primitiveWrapperTypeMap.put(Byte.class, byte.class);
        primitiveWrapperTypeMap.put(Character.class, char.class);
        primitiveWrapperTypeMap.put(Double.class, double.class);
        primitiveWrapperTypeMap.put(Float.class, float.class);
        primitiveWrapperTypeMap.put(Integer.class, int.class);
        primitiveWrapperTypeMap.put(Long.class, long.class);
        primitiveWrapperTypeMap.put(Short.class, short.class);

        for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperTypeMap.entrySet()) {
            primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
            registerCommonClasses(entry.getKey());
        }

        Set<Class<?>> primitiveTypes = new HashSet<>(32);
        primitiveTypes.addAll(primitiveWrapperTypeMap.values());
        Collections.addAll(primitiveTypes, boolean[].class, byte[].class, char[].class,
                double[].class, float[].class, int[].class, long[].class, short[].class);
        primitiveTypes.add(void.class);
        for (Class<?> primitiveType : primitiveTypes) {
            primitiveTypeNameMap.put(primitiveType.getName(), primitiveType);
        }

        registerCommonClasses(Boolean[].class, Byte[].class, Character[].class, Double[].class,
                Float[].class, Integer[].class, Long[].class, Short[].class);
        registerCommonClasses(Number.class, Number[].class, String.class, String[].class,
                Class.class, Class[].class, Object.class, Object[].class);
        registerCommonClasses(Throwable.class, Exception.class, RuntimeException.class,
                Error.class, StackTraceElement.class, StackTraceElement[].class);
        registerCommonClasses(Enum.class, Iterable.class, Iterator.class, Enumeration.class,
                Collection.class, List.class, Set.class, Map.class, Map.Entry.class, Optional.class);

        Class<?>[] javaLanguageInterfaceArray = {Serializable.class, Externalizable.class,
                Closeable.class, AutoCloseable.class, Cloneable.class, Comparable.class};
        registerCommonClasses(javaLanguageInterfaceArray);
        javaLanguageInterfaces = new HashSet<>(Arrays.asList(javaLanguageInterfaceArray));
    }

    /**
     * 注册常用的类型
     * @param commonClasses
     */
    private static void registerCommonClasses(Class<?>... commonClasses) {
        for (Class<?> commonClass : commonClasses) {
            commonClassCache.put(commonClass.getName(), commonClass);
        }
    }

    /**
     * 获取默认类加载器
     * @return
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable t) {
            // Cannot access thread context ClassLoader - failling back...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            // 没有线程上下文类加载器 -> 使用该类的类加载器
            cl = Classes.class.getClassLoader();
            if (cl == null) {
                // getClassLoader() returning null indicates the bootstrap ClassLoader
                // 该类的类加载器运行为空，表示引导类加载器
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable t) {
                    // Cannot access system ClassLoader - oh well, maybe the caller can live with null...
                    // 无法访问系统类加载器 - 哦，也许调用者可以使用null.
                }
            }
        }
        return cl;
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
     * 如果给定的类是基本类型，则返回它对应的相应包装类
     * @param clazz
     * @return
     */
    public static Class<?> resolvePrimitiveIfNecessary(Class<?> clazz) {
        Assert.checkNotNull(clazz, "Class must not be null.");
        return (clazz.isPrimitive() && clazz != void.class ? primitiveTypeToWrapperMap.get(clazz) : clazz);
    }

    /**
     * 检测是否可以将sourceType代表的类型转换到targetType代表的类型
     * @param sourceType        要转换的类型
     * @param targetType        目标的类型
     * @return
     */
    public static boolean isAssignable(Class<?> sourceType, Class<?> targetType) {
        Assert.checkNotNull(sourceType, "Left-hand side type must not be null");
        Assert.checkNotNull(targetType, "Right-hand side type must not be null");
        if (sourceType.isAssignableFrom(targetType)) {
            return true;
        }
        if (sourceType.isPrimitive()) {
            // 判断类型是否是基本类型，例如：int，float

            // 如果类型是基本类型，则我们要从缓存包装对应基本的映射集合中，使用targetType，从中获取对应的基本类型
            Class<?> resolvedPrimitive = primitiveWrapperTypeMap.get(targetType);
            if (sourceType == resolvedPrimitive) {
                return true;
            }
        } else {
            // 如果不是基本类型，就是包装类型，例如：Integer，Float

            // 如果sourceType是不是基本类型，则我们要从缓存基本对应包装的映射集合中，使用targetType，从中获取对应的包装类型
            Class<?> resolvedWrapper = primitiveTypeToWrapperMap.get(targetType);
            if (resolvedWrapper != null && sourceType.isAssignableFrom(resolvedWrapper)) {
                return true;
            }
        }
        return false;
    }

}
