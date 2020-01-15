package me.hireny.commons.utils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ReflectUtils
 * @Description: TODO   对反射进行增强的工具类
 * @Author: hireny
 * @Date: Created in 2020-01-08 8:25
 * @Version: 1.0
 */
public final class ReflectUtils {

    private ReflectUtils() {}

    private static final String SETTER_PREFIX = "set";

    private static final String GETTER_PREFIX = "get";

    private static final String CGLIB_CLASS_SEPARATOR = "$$";

    /**
     * 空的 Class 类数组
     */
    private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];

    /**
     * 空的 Method 方法数组
     */
    private static final Method[] EMPTY_METHOD_ARRAY = new Method[0];

    /**
     * 空的 Field 字段数组
     */
    private static final Field[] EMPTY_FIELD_ARRAY = new Field[0];

    /**
     * 空的 Object 对象数组
     */
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

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
    private static final Map<Class<?>, Method[]> declaredMethodsCache = new ConcurrentHashMap<>(256);

    /**
     * Cache for {@link Class#getDeclaredFields()}, allowing for fast iteration.
     */
    private static final Map<Class<?>, Field[]> declaredFieldsCache = new ConcurrentHashMap<>(256);

    //======================================================
    //  异常处理
    //======================================================

    public static void handleReflectionException(Exception e) {
        if (e instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + e.getMessage());
        }
        if (e instanceof IllegalAccessException) {
            throw new IllegalStateException("Could not access method(无法访问方法): " + e.getMessage());
        }
        if (e instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) e);
        }
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        }
        throw new UndeclaredThrowableException(e);
    }

    public static void handleInvocationTargetException(InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    public static void rethrowRuntimeException(Throwable e) {
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        }
        if (e instanceof Error) {
            throw (Error) e;
        }
        throw new UndeclaredThrowableException(e);
    }

    //=====================================================
    // 属性处理(Field)
    //=====================================================

    /**
     * 获取类属性(包含私有以及受保护的，父类也会检索)
     * @param clazz             类
     * @param fieldName         属性名称
     * @return                  属性
     */
    public static Field findField(Class<?> clazz, String fieldName) {
        return findField(clazz, fieldName, null);
    }

    public static Field findField(Class<?> clazz,  String name,  Class<?> type) {
        Assert.checkNotNull(clazz, "Class must not be null");
        Assert.isTrue(name != null || type != null, "Either name or type of the field must be specified");
        Class<?> searchType = clazz;
        while (Object.class != searchType && searchType != null) {
            Field[] fields = getDeclaredFields(searchType);
            for (Field field : fields) {
                if ( (name == null || name.equals(field.getName())) &&
                        (type == null || type.equals(field.getType())) ) {
                    return field;
                }
            }
            // for循环之后，没有找到名为name或者类型为type的字段，
            // 则设置搜索类型为父类，再次进行while循环
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * 获取属性的值
     * @param object        对象
     * @param fieldName     属性名
     * @return              属性值
     */
    public static Object findFieldValue(Object object, String fieldName) {
        Object value = null;
        if (object != null) {
            Field field = findField(object.getClass(), fieldName);
            if (field != null) {
                field.setAccessible(true);
                try {
                    value = field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Field is not exist.");
            }
        }
        return value;
    }

    /**
     * 获取静态属性值
     * @param sourceClass   类
     * @param fieldName     属性名
     * @return              属性值
     */
    public static Object findFieldValue(Class<?> sourceClass, String fieldName) {
        Field field = findField(sourceClass, fieldName);
        Object value = null;
        if (field != null) {
            field.setAccessible(true);
            if (isStatic(field)) {
                try {
                    value = field.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Field is not static");
            }
        } else {
            System.err.println("Field is not exist");
        }
        return value;
    }

    /**
     * 设置属性值
     * @param object        对象
     * @param fieldName     属性名
     * @param newValue      新值
     */
    public static void setFieldValue(Object object, String fieldName, Object newValue) {
        if (object != null) {
            Field field = findField(object.getClass(), fieldName);
            if (field != null) {
                field.setAccessible(true);
                if (!isFinal(field)) {
                    try {
                        field.set(object, newValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Field is final");
                }
            } else {
                System.err.println("Field is not exist");
            }
        }
    }

    /**
     * 设置静态属性值
     * @param clazz         类
     * @param fieldName     属性名
     * @param newValue      新值
     */
    public static void setFieldValue(Class<?> clazz, String fieldName, Object newValue) {
        Field field = findField(clazz, fieldName);
        System.out.println(field);
        if (field != null) {
            field.setAccessible(true);
            if (isStatic(field)) {
                if (!isFinal(field)) {
                    try {
                        field.set(null, newValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Field is final");
                }
            } else {
                System.err.println("Field is not static");
            }
        } else {
            System.err.println("Field is not exist");
        }
    }


    /**
     * This variant retrieves {@link Class#getDeclaredFields()} from a local cache
     * in order to avoid the JVM's SecurityManager check and defensive array copying.
     * @param clazz the class to introspect
     * @return the cached array of fields
     * @throws IllegalStateException if introspection fails
     * @see Class#getDeclaredFields()
     */
    private static Field[] getDeclaredFields(Class<?> clazz) {
        Assert.checkNotNull(clazz, "Class must not be null");
        Field[] result = declaredFieldsCache.get(clazz);
        if (result == null) {
            try {
                result = clazz.getDeclaredFields();
                declaredFieldsCache.put(clazz, (result.length == 0 ? EMPTY_FIELD_ARRAY : result));
            } catch (Throwable t) {
                throw new IllegalStateException("Failed to introspect Class [" + clazz.getName() +
                        "] from ClassLoader [" + clazz.getClassLoader() + "]", t);
            }
        }
        return result;
    }


    public static void setField(Field field,  Object target,  Object value) {
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(
                    "Unexpected reflection exception(意想不到的反射异常) - " + e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public static Object getField(Field field,  Object target) {
        try {
            return field.get(target);
        }
        catch (IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    //======================================================
    //  方法处理
    //======================================================

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and no parameters. Searches all superclasses up to {@code Object}.
     * <p>Returns {@code null} if no {@link Method} can be found.
     * @param clazz the class to introspect
     * @param name the name of the method
     * @return the Method object, or {@code null} if none found
     */
    /**
     * 通过反射技术找到方法
     * @param clazz
     * @param methodName
     * @return
     */
    public static Method findMethod(Class<?> clazz, String methodName) {
        return findMethod(clazz, methodName, EMPTY_CLASS_ARRAY);
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
            Method[] methods = searchType.isInterface() ?
                    searchType.getMethods() :
                    getDeclaredMethods(searchType, false);
            for (Method method : methods) {
                if (methodName.equals(method.getName()) &&
                        (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * 调用方法
     * @param method
     * @param target
     * @return
     */
    public static Object invokeMethod(Method method,  Object target) {
        return invokeMethod(method, target, EMPTY_OBJECT_ARRAY);
    }

    /**
     * 执行类方法
     * @param source        类对象
     * @param methodName    方法名
     * @param args          参数数组
     * @return              执行结果
     */
    public static Object invokeMethod(Object source, String methodName, Object... args) {
        Class<?>[] classes = null;
        if (args != null) {
            classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
        }
        Method method = findMethod(source.getClass(), methodName, classes);
        Object result = null;
        try {
            if (method != null) {
                method.setAccessible(true);
                result = method.invoke(source, args);
            } else {
                System.err.println("Method is not exist");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 调用方法
     * @param method
     * @param target
     * @param args
     * @return
     */
    public static Object invokeMethod(Method method,  Object target,  Object... args) {
        try {
            return method.invoke(target, args);
        } catch (Exception e) {
            handleReflectionException(e);
        }
        throw new IllegalStateException("Should never get here.(永远也到不了这)");
    }

    /**
     * Variant of {@link Class#getDeclaredMethods()} that uses a local cache in
     * order to avoid the JVM's SecurityManager check and new Method instances.
     * In addition, it also includes Java 8 default methods from locally
     * implemented interfaces, since those are effectively to be treated just
     * like declared methods.
     * @param clazz the class to introspect
     * @return the cached array of methods
     * @throws IllegalStateException if introspection fails
     * @since 5.2
     * @see Class#getDeclaredMethods()
     */
    public static Method[] getDeclaredMethods(Class<?> clazz) {
        return getDeclaredMethods(clazz, true);
    }

    private static Method[] getDeclaredMethods(Class<?> clazz, boolean defensive) {
        Assert.checkNotNull(clazz, "Class must not be null");
        Method[] result = declaredMethodsCache.get(clazz);
        if (result == null) {
            try {
                Method[] declaredMethods = clazz.getDeclaredMethods();
                List<Method> defaultMethods = findConcreteMethodsOnInterfaces(clazz);
                if (defaultMethods != null) {
                    result = new Method[declaredMethods.length + defaultMethods.size()];
                    System.arraycopy(declaredMethods, 0, result, 0, declaredMethods.length);
                    int index = declaredMethods.length;
                    for (Method defaultMethod : defaultMethods) {
                        result[index] = defaultMethod;
                        index++;
                    }
                }
                else {
                    result = declaredMethods;
                }
                declaredMethodsCache.put(clazz, (result.length == 0 ? EMPTY_METHOD_ARRAY : result));
            }
            catch (Throwable ex) {
                throw new IllegalStateException("Failed to introspect Class [" + clazz.getName() +
                        "] from ClassLoader [" + clazz.getClassLoader() + "]", ex);
            }
        }
        return (result.length == 0 || !defensive) ? result : result.clone();
    }


    private static List<Method> findConcreteMethodsOnInterfaces(Class<?> clazz) {
        List<Method> result = null;
        for (Class<?> ifc : clazz.getInterfaces()) {
            for (Method ifcMethod : ifc.getMethods()) {
                if (!Modifier.isAbstract(ifcMethod.getModifiers())) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(ifcMethod);
                }
            }
        }
        return result;
    }

    //============================================
    //  对象判断标识符
    //============================================

    /**
     * 是否静态（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isStatic(Object field) {
        return Modifier.isStatic((Integer) invokeMethod(field, "getModifiers", null));
    }

    /**
     * 是否不可变/覆写（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isFinal(Object field) {
        return Modifier.isFinal((Integer) invokeMethod(field, "getModifiers", null));
    }

    /**
     * 是否公共（方法、属性。。。）
     *
     * @param field 要判断的对象
     * @return 是否
     */
    public static boolean isPublic(Object field) {
        return Modifier.isPublic((Integer) invokeMethod(field, "getModifiers", null));
    }

    /**
     * 是否私有(方法、属性...)
     * @param source 要判断的对象
     * @return
     */
    public static boolean isPrivate(Object source) {
        return Modifier.isPrivate((Integer) invokeMethod(source, "getModifiers", null));
    }

    /**
     * 是否受保护(方法、属性...)
     * @param source    要判断的对象
     * @return
     */
    public static boolean isProtected(Object source) {
        return Modifier.isProtected((Integer) invokeMethod(source, "getModifiers", null));
    }

    /**
     * Determine whether the given method is an "equals" method.
     *
     * 确定给定的方法是否是 一个 "equals" 方法
     * @see Object#equals(Object)
     */
    public static boolean isEqualsMethod( Method method) {
        if (method == null || !method.getName().equals("equals")) {
            return false;
        }
        Class<?>[] paramTypes = method.getParameterTypes();
        return (paramTypes.length == 1 && paramTypes[0] == Object.class);
    }

    /**
     * Determine whether the given method is a "hashCode" method.
     *
     * 确定给定的方法是否是一个 "hashCode" 方法
     * @see Object#hashCode()
     */
    public static boolean isHashCodeMethod( Method method) {
        return (method != null && method.getName().equals("hashCode") && method.getParameterCount() == 0);
    }


    //======================================================
    //  清除缓存的方法
    //======================================================

    /**
     * Clear the internal method/field cache.
     * @since 4.2.4
     */
    public static void clearCache() {
        declaredMethodsCache.clear();
        declaredFieldsCache.clear();
    }
}
