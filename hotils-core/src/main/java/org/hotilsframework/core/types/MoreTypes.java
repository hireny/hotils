package org.hotilsframework.core.types;

import org.hotilsframework.lang.reflects.CompositeType;
import org.hotilsframework.lang.Assert;
import org.hotilsframework.lang.reflects.GenericArrayTypeImpl;

import java.lang.reflect.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author hireny
 * @className MoreTypes
 * @create 2020-06-08 11:02
 */
public class MoreTypes {
    /**
     * 如果 {@code type} 没有类型变量，则返回true。
     * @param type
     * @return
     */
    public static boolean isFullySpecified(Type type) {
        if (type instanceof Class) {
            return true;

        } else if (type instanceof CompositeType) {
            return ((CompositeType) type).isFullySpecified();

        } else if (type instanceof TypeVariable) {
            return false;

        } else {
            return ((CompositeType) canonicalize(type)).isFullySpecified();
        }
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class<?> c = (Class<?>) type;
            return c.isArray() ? new GenericArrayTypeImpl(canonicalize(c.getComponentType())) : c ;

        } else if (type instanceof CompositeType) {
            return type;

        } else if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) type;
//            return new ParameterizedTypeImpl(p.getOwnerType());
            return null;
        }
        return type;
    }

    /**
     * 获取原始类型
     * <p>
     *     例如：{@code Generic<String>} 泛型，使用该方法，获得 {@code Generic} 类型
     * </p>
     * @param type
     * @return
     */
    public static Class<?> getRawType(Type type) {
        if (type instanceof Class<?>) {
            // type is a normal class 类型是一个普通类型
            return (Class<?>) type;

        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            Assert.checkArgument(rawType instanceof Class, "Expected a Class, but <%s> is of type %s", type, type.getClass().getName());
            return (Class<?>) rawType;

        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(getRawType(componentType), 0).getClass();

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

    public static boolean equals(Type a, Type b) {
        if (a == b) {
            return true;
        } else if (a instanceof Class) {
            return a.equals(b);
        } else if (a instanceof ParameterizedType) {
            if (!(b instanceof ParameterizedType)) {
                return false;
            }

            ParameterizedType pa = (ParameterizedType) a;
            ParameterizedType pb = (ParameterizedType) b;
            return Objects.equals(pa.getOwnerType(), pb.getOwnerType())
                    && pa.getRawType().equals(pb.getRawType())
                    && Arrays.equals(pa.getActualTypeArguments(), pb.getActualTypeArguments());

        } else if (a instanceof GenericArrayType) {
            if (!(b instanceof GenericArrayType)) {
                return false;
            }

            GenericArrayType ga = (GenericArrayType) a;
            GenericArrayType gb = (GenericArrayType) b;
            return equals(ga.getGenericComponentType(), gb.getGenericComponentType());

        } else if (a instanceof WildcardType) {
            if (!(b instanceof WildcardType)) {
                return false;
            }

            WildcardType wa = (WildcardType) a;
            WildcardType wb = (WildcardType) b;
            return Arrays.equals(wa.getUpperBounds(), wb.getUpperBounds())
                    && Arrays.equals(wa.getLowerBounds(), wb.getLowerBounds());

        } else if (a instanceof TypeVariable) {
            if (!(b instanceof TypeVariable)) {
                return false;
            }
            TypeVariable<?> va = (TypeVariable<?>) a;
            TypeVariable<?> vb = (TypeVariable<?>) b;
            return va.getGenericDeclaration().equals(vb.getGenericDeclaration())
                    && va.getName().equals(vb.getName());
        }
        // 这不是我们支持的类型。可以是泛型数组类型，通配符类型，等等。
        return false;
    }

    private static int hashCodeOrZero(Object o) {
        return o != null ? o.hashCode() : 0;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type getGenericSupertype(Type type, Class<?> rawType, Class<?> toResolve) {
        if (toResolve == rawType) {
            return type;
        }

        if (toResolve.isInterface()) {
            Class[] interfaces = rawType.getInterfaces();
            for (int i = 0, length = interfaces.length; i < length; i++) {
                if (interfaces[i] == toResolve) {
                    return rawType.getGenericInterfaces()[i];
                } else if (toResolve.isAssignableFrom(interfaces[i])) {
                    return getGenericSupertype(rawType.getGenericInterfaces()[i], interfaces[i], toResolve);
                }
            }
        }

        // check our supertypes 检查我们的超类型
        if (!rawType.isInterface()) {
            while (rawType != Object.class) {
                Class<?> rawSupertype = rawType.getSuperclass();
                if (rawSupertype == toResolve) {
                    return rawType.getGenericSuperclass();
                } else if (toResolve.isAssignableFrom(rawSupertype)) {
                    return getGenericSupertype(rawType.getGenericSuperclass(), rawSupertype, toResolve);
                }
                rawType =rawSupertype;
            }
        }

        // we can't resolve this further
        return toResolve;
    }

    public static Type resolveTypeVariable(Type type, Class<?> rawType, TypeVariable unknown) {
        Class<?> declaredByRaw = declaringClassOf(unknown);

        // we can't reduce this further
        if (declaredByRaw == null) {
            return unknown;
        }

        Type declaredBy = getGenericSupertype(type,rawType, declaredByRaw);
        if (declaredBy instanceof ParameterizedType) {
            int index = indexOf(declaredByRaw.getTypeParameters(), unknown);
            return ((ParameterizedType) declaredBy).getActualTypeArguments()[index];
        }
        return unknown;
    }

    private static int indexOf(Object[] array, Object toFind) {
        for (int i = 0; i < array.length; i++) {
            if (toFind.equals(array[i])) {
                return i;
            }
        }
        // 抛出异常，没有这样的元素
        throw new NoSuchElementException();
    }

    /**
     * 如果不是由类声明，则返回声明类 {@code TypeVariable}，或者 {@code null}
     * @param typeVariable
     * @return
     */
    private static Class<?> declaringClassOf(TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class<?>) genericDeclaration : null;
    }
}
