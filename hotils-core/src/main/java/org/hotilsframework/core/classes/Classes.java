package org.hotilsframework.core.classes;

import org.hotilsframework.utils.Assert;

import java.lang.reflect.Modifier;

/**
 * Classes
 *
 * 类信息
 *
 * @author hireny
 * @create 2020-07-26 10:12
 */
public class Classes {

    /**
     * 获得对象数组的类数组
     * @param args      对象数组，如果数组中存在{@code null}元素，则此元素被认为是Object类型
     * @return          类数组
     */
    public static Class<?>[] getClasses(Object... args) {

        if (null == args) {
            return null;
        }

        Class<?>[] classes = new Class[args.length];
        Object o;
        for (int i = 0; i < args.length; i++) {
            o = args[i];
            classes[i] = (null == o) ? Object.class : o.getClass();
        }
        return classes;
    }

    /**
     * Double 默认值
     */
    private static final Double DOUBLE_DEFAULT = 0D;
    /**
     * Float 默认值
     */
    private static final Float FLOAT_DEFAULT = 0F;

    /**
     * 返回默认值
     * @param type
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T defaultValue(Class<T> type) {
        Assert.notNull(type);
        if (type == boolean.class) {
            return (T) Boolean.FALSE;
        } else if (type == char.class) {
            return (T) Character.valueOf('\0');
        } else if (type == byte.class) {
            return (T) Byte.valueOf((byte) 0);
        } else if (type == short.class) {
            return (T) Short.valueOf((short) 0);
        } else if (type == int.class) {
            return (T) Integer.valueOf(0);
        } else if (type == long.class) {
            return (T) Long.valueOf(0L);
        } else if (type == float.class) {
            return (T) FLOAT_DEFAULT;
        } else if (type == double.class) {
            return (T) DOUBLE_DEFAULT;
        }
        return null;
    }

    /**
     * 获得默认值列表
     *
     * @param classes       值类型
     * @return              默认值列表
     */
    public static Object[] defaultValues(Class<?>... classes) {
        final Object[] values = new Object[classes.length];
        for (int i = 0; i < classes.length; i++) {
            values[i] = defaultValue(classes[i]);
        }
        return values;
    }

    /**
     * 判断类型是否是基本类型
     * @param clazz     类
     * @return          是否为基本类型，如果为 {@code null} 返回false
     */
    public static boolean isPrimitive(Class<?> clazz) {
        if (null ==clazz) {
            return false;
        }
        return clazz.isPrimitive();
    }

    /**
     * 判断类是否为数组
     * @param clazz     类
     * @return          是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return clazz.isArray();
    }

    /**
     * 判断类是否是接口
     * @param clazz     类
     * @return          是否为接口，如果为 {@code null} 返回false
     */
    public static boolean isInterface(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return clazz.isInterface();
    }

    /**
     * 判断类是否是抽象类
     * @param clazz     类
     * @return          是否为抽象类，如果为 {@code null} 返回false
     */
    public static boolean isAbstractClass(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return Modifier.isAbstract(clazz.getModifiers());
    }

    /**
     * 判断类是否是系统内部类
     * @param clazz     类
     * @return
     */
    public static boolean isAnonymousClass(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return clazz.isAnonymousClass();
    }

    /**
     * 判断类是否是枚举类
     * @param clazz     类
     * @return          是否为枚举类，如果为 {@code null} 返回false
     */
    public static boolean isEnumClass(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return clazz.isEnum();
    }

    /**
     * 判断是否是注解类
     * @param clazz     类
     * @return          是否为注解类，如果为 {@code null} 返回false
     */
    public static boolean isAnnotationClass(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return clazz.isAnnotation();
    }
}
