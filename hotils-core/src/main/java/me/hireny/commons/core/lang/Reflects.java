package me.hireny.commons.core.lang;

import me.hireny.commons.utils.Assert;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Reflects
 * 对反射进行增强
 * @Author: hireny
 * @Date: Create in 2019/10/03 22:30
 */
public class Reflects {

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
    
    public static Method findMethod(Class<?> clazz, String name) {
        return findMethod(clazz, name, EMPTY_CLASS_ARRAY);
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and parameter types. Searches all superclasses up to {@code Object}.
     * <p>Returns {@code null} if no {@link Method} can be found.
     * @param clazz the class to introspect
     * @param name the name of the method
     * @param paramTypes the parameter types of the method
     * (may be {@code null} to indicate any signature)
     * @return the Method object, or {@code null} if none found
     */
    
    public static Method findMethod(Class<?> clazz, String name,  Class<?>... paramTypes) {
        Assert.checkNotNull(clazz, "Class must not be null");
        Assert.checkNotNull(name, "Method name must not be null");
        Class<?> searchType = clazz;
        while (searchType != null) {
            Method[] methods = searchType.isInterface() ?
                    searchType.getMethods() :
                    getDeclaredMethods(searchType, false);
            for (Method method : methods) {
                if (name.equals(method.getName()) &&
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
    //  设置 Field 字段
    //======================================================

    
    public static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
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
    //  获取Field的类型信息
    //======================================================

//    public static Class<?>


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
