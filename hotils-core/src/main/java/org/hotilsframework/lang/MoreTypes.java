package org.hotilsframework.lang;

import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;

import java.lang.reflect.*;
import java.lang.reflect.Array;

/**
 * @author hireny
 * @className MoreTypes
 * @create 2020-06-08 11:02
 */
public class MoreTypes {

    public static Type canonicalize(Type type) {
//        if (type instanceof Class) {
//            Class<?> c = (Class<?>) type;
//            return c.isArray() ? new GenericArrayTypeImpl()
//        }
        return type;
    }

    public static Class<?> getRawTYpe(Type type) {
        if (type instanceof Class<?>) {
            // type is a normal class 类型是一个普通类型
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return (Class<?>) rawType;

        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(getRawTYpe(componentType), 0).getClass();

        } else if (type instanceof TypeVariable || type instanceof WildcardType) {
            // 返回更通用的对象类型
            return Object.class;
        } else {
            // 抛出参数异常
            // 期望类，参数化类型或泛型数组类型，但 <type> 是类型 type.getClass().getName()
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or " +
                    "GenericArrayType, but <" +
                    type + "> is of type " + type.getClass().getName());
        }
    }
}
