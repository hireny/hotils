package org.hotilsframework.utils;

import org.hotilsframework.core.Classes;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ReflectUtils
 * @Description: TODO   对反射进行增强的工具类
 * @Author: hireny
 * @Date: Created in 2020-01-08 8:25
 * @Version: 1.0
 */
public final class ReflectionUtils {

    private ReflectionUtils() {}

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
     * 获取类中的字段信息(包含私有以及受保护的，父类也会检索)
     * @param clazz             类
     * @param name              属性名称
     * @return                  属性
     */
    public static Field getField(Class<?> clazz, String name) {
        return getField(clazz, name, null);
    }

    /**
     * 获取类中的字段信息(包含私有以及受保护的，父类也会检索)
     * @param clazz             类
     * @param name              属性名称
     * @param type              属性类型
     * @return
     */
    public static Field getField(Class<?> clazz,  String name,  Class<?> type) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.isTrue(name != null || type != null, "Either name or type of the field must be specified");
        Class<?> searchType = clazz;
        while (Object.class != searchType && searchType != null) {
            Field[] fields = getFields(searchType);
            for (Field field : fields) {
                if ( (name == null || name.equals(field.getName())) &&
                        (type == null || type.equals(field.getType())) ) {  // 判断字段名称与字段类型
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
     * 获取一个类中所有字段列表，括父类
     * @param clazz
     * @return
     */
    public static Field[] getFields(Class<?> clazz) {
        Field[] fields = getFields(clazz, true);
        return fields;
    }

    /**
     * 获得一个类中所有字段列表，直接反射获取，无缓存
     * @param clazz                     类
     * @param withSuperClassFields      是否包括父类的字段列表
     * @return
     */
    public static Field[] getFields(Class<?> clazz, boolean withSuperClassFields) {
        Assert.notNull(clazz);

        Field[] allFields = null;
        Class<?> searchType = clazz;
        Field[] declaredFields;
        while (searchType != null) {
            // 获取所有字段
            declaredFields = searchType.getDeclaredFields();
            if (null == allFields) {
                allFields = declaredFields;
            } else {
                allFields = ArrayUtils.append(allFields, declaredFields);
            }
            searchType = withSuperClassFields ? searchType.getSuperclass() : null;
        }
        return allFields;
    }

    /**
     * 获取静态属性值
     * @param clazz         类
     * @param fieldName     属性名
     * @return              属性值
     */
    public static Object getFieldValue(Class<?> clazz, String fieldName) {
        if (null == clazz || StringUtils.isBlank(fieldName)) {
            return null;
        }
        return getFieldValue(clazz, getField(clazz, fieldName));
    }

    /**
     * 获取静态字段值
     * @param clazz
     * @param field
     * @return
     */
    public static Object getFieldValue(Class<?> clazz, Field field) {
        if (null == clazz || null == field) {
            return null;
        }
        makeAccessible(field);
        Object result = null;
        try {
            result = field.get(null);
        } catch (IllegalAccessException e) {
            handleReflectionException(e);
        }
        return result;
    }

    /**
     * 获取属性的值
     * @param object        对象
     * @param fieldName     属性名
     * @return              属性值
     */
    public static Object getFieldValue(Object object, String fieldName) {
        if (null == object || StringUtils.isBlank(fieldName)) {
            return null;
        }
        return getFieldValue(object, getField(object.getClass(), fieldName));
    }

    /**
     * 获取属性值
     * @param object    对象
     * @param field     字段
     * @return          字段值
     */
    public static Object getFieldValue(Object object, Field field) {
        if (null == object || null == field) {
            return null;
        }
        makeAccessible(field);
        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            handleReflectionException(e);
        }
        return result;
    }

    /**
     * 设置属性值
     *
     * @param target    目标对象
     * @param field     字段
     * @param value     值
     */
    public static void setFieldValue(Object target, Field field,  Object value) {
        Assert.notNull(target);
        Assert.notNull(field, "Field in [{}] not exist !", target.getClass().getName());

        // 可以添加类型转换，将 value 转换为 field 字段的类型

        try {
            makeAccessible(field);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(
                    "Unexpected reflection exception(意想不到的反射异常) - " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 设置属性值
     * @param object        对象
     * @param fieldName     属性名
     * @param newValue      新值
     */
    public static void setFieldValue(Object object, String fieldName, Object newValue) {
        Assert.notNull(object);
        Assert.notBlank(fieldName);

        final Field field = getField(object.getClass(), fieldName);
        setFieldValue(object, field, newValue);
    }

    /**
     * 设置静态属性值
     * @param clazz         类
     * @param fieldName     属性名
     * @param newValue      新值
     */
    public static void setFieldValue(Class<?> clazz, String fieldName, Object newValue) {
        Assert.notNull(clazz);
        Assert.notBlank(fieldName);


        Field field = getField(clazz, fieldName);
        try {
            makeAccessible(field);
            field.set(null, newValue);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(
                    "Unexpected reflection exception(意想不到的反射异常) - " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    //======================================================
    //  构造器处理 start
    //======================================================

    /**
     * 获取某个 Constructor
     * @param clazz             类
     * @param parameterTypes    参数类型，只要任何一个参数是指定参数的父类或接口或相等即可，此参数可以不传
     * @param <T>               对象类型
     * @return                  构造方法，如果未找到返回null
     */
    @SuppressWarnings("unchecked")
    public static <T>  Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
        if (null == clazz) {
            return null;
        }

        final Constructor<?>[] constructors = getConstructors(clazz);
        Class<?>[] pts;
        for (Constructor<?> constructor : constructors) {
            pts = constructor.getParameterTypes();
            if (ClassUtils.isAssignableFrom(pts, parameterTypes)) {
                // 构造可访问
                makeAccessible(constructor);
                return (Constructor<T>) constructor;
            }

        }
        return null;
    }

    /**
     * 获取一个类中所有构造方法
     * @param clazz     类
     * @param <T>       构造的对象类型
     * @return          构造方法数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Constructor<T>[] getConstructors(Class<T> clazz) {
        Assert.notNull(clazz);
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        return (Constructor<T>[]) constructors;
    }


    //======================================================
    //  构造器处理 end
    //======================================================


    //======================================================
    //  方法处理
    //======================================================

    /**
     * 查找指定类中的方法，包括父类
     * @param clazz         累
     * @param methodName    方法名称
     * @return              方法
     */
    public static Method getMethod(Class<?> clazz, String methodName) {
        return getMethod(clazz, methodName, EMPTY_CLASS_ARRAY);
    }
    /**
     * 查找指定类中的方法，包括父类
     * @param clazz         类
     * @param methodName    方法名称
     * @param paramTypes    参数类型
     * @return              方法
     */
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.notNull(methodName, "Method name must not be null");

        Method[] allMethods = getMethods(clazz);

        for (Method method : allMethods) {
            if (methodName.equals(method.getName()) &&
                    (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                return method;
            }
        }
        return null;
    }

    /**
     * 获取一个类中所有方法列表，包括其父类中的方法
     * @param clazz     类
     * @return          方法列表
     */
    public static Method[] getMethods(Class<?> clazz) {
        return getMethods(clazz, true);
    }

    /**
     * 获取一个类中所有方法列表
     * @param clazz                     类
     * @param withSuperClassMethods     是否包括父类的方法列表
     * @return                          方法列表
     */
    public static Method[] getMethods(Class<?> clazz, boolean withSuperClassMethods) {
        Assert.notNull(clazz, "class must not be null");

        Method[] allMethods = null;
        Class<?> searchType = clazz;
        Method[] declaredMethods;
        List<Method> defaultMethodLists;
        while (searchType != null) {
            declaredMethods = searchType.getDeclaredMethods();
            defaultMethodLists = getConcreteMethodsOnInterfaces(searchType);

            if (null != defaultMethodLists) {

                // 将 List 转为 数组
                Method[] defaultMethods = new Method[defaultMethodLists.size()];

                defaultMethodLists.toArray(defaultMethods);

                declaredMethods = ArrayUtils.append(declaredMethods, defaultMethods);
            }

            if (null == allMethods) {
                allMethods = declaredMethods;
            } else {
                allMethods = ArrayUtils.append(allMethods, declaredMethods);
            }
            searchType = withSuperClassMethods ? searchType.getSuperclass() : null;
        }
        return allMethods;
    }

    /**
     * 获取接口中具体的方法
     * @param clazz     类
     * @return
     */
    private static List<Method> getConcreteMethodsOnInterfaces(Class<?> clazz) {

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
     * 执行对象中指定方法
     * @param target        类对象
     * @param methodName    方法名
     * @param args          参数数组
     * @return              执行结果
     * @throws IllegalAccessException   异常
     */
    public static Object invoke(Object target, String methodName, Object... args) throws IllegalAccessException {
        Class<?>[] classes = Classes.getClasses(args);

        Method method = getMethod(target.getClass(), methodName, classes);

        if (null == method) {
            throw new IllegalAccessException(StringUtils.format("No such method: [{}]", methodName));
        }

        return invoke(target, method, args);
    }

    /**
     *
     * 执行方法
     * @param method    方法（对象方法或static方法都可以）
     * @param target    对象，如果执行静态方法，此值为 {@code null}
     * @param args      参数对象
     * @return          结果
     */
    public static Object invoke(Object target, Method method,  Object... args) {
        makeAccessible(method);
        try {
            return method.invoke(target, args);
        } catch (Exception e) {
            handleReflectionException(e);
        }
        throw new IllegalStateException("Should never get here.(永远也到不了这)");
    }

    /**
     * 确定给定的方法是否是 一个 "equals" 方法
     *
     * @param method            类中方法
     * @return  如果是则返回true，否则返回false
     * @see Object#equals(Object)
     */
    public static boolean isEqualsMethod(Method method) {
        if (method == null || !"equals".equals(method.getName())) {
            return false;
        }
        Class<?>[] paramTypes = method.getParameterTypes();
        return (paramTypes.length == 1 && paramTypes[0] == Object.class);
    }

    /**
     * 确定给定的方法是否是一个 "hashCode" 方法
     *
     * @param method            给定类中的方法
     * @return      如果是则返回true，否则返回false
     * @see Object#hashCode()
     */
    public static boolean isHashCodeMethod(Method method) {
        return (method != null && "hashCode".equals(method.getName()) && method.getParameterCount() == 0);
    }


    /**
     * 设置方法为可访问（私有方法可以被外部调用）
     * @param accessibleObject      可设置访问权限的对象，比如Class、Method、Field、Constructor等
     * @param <T>                   AccessibleObject的子类，比如Class、Method、Field、Constructor等
     * @return                      被设置可访问的对象
     */
    public static <T extends AccessibleObject> T makeAccessible(T accessibleObject) {
        if (null != accessibleObject && false == accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }


    //=====================================================
    // 实例化
    //=====================================================



    //======================================================
    //  清除缓存的方法
    //======================================================

    /**
     * Clear the internal method/field cache.
     * @since 4.2.4
     */
    public static void clearCache() {

    }
}
