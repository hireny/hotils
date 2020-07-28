package org.hotilsframework.core.types;

import org.hotilsframework.collect.ImmutableList;
import org.hotilsframework.lang.NestedRuntimeException;
import org.hotilsframework.core.reflects.Types;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * @author hireny
 * @className TypeLiteral
 * @create 2020-06-08 10:45
 */
public class TypeLiteral<T> {
    /**
     * 原始类型
     */
    final Class<? super T> rawType;
    /**
     * 类型
     */
    final Type type;
    /**
     * hashCode值
     */
    final int hashCode;

    @SuppressWarnings("unchecked")
    protected TypeLiteral() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = (Class<? super T>) MoreTypes.getRawType(type);
        this.hashCode = type.hashCode();
    }

    @SuppressWarnings("unchecked")
    TypeLiteral(Type type) {
        this.type = MoreTypes.canonicalize(getClass());
        this.rawType = (Class<? super T>) MoreTypes.getRawType(type);
        this.hashCode = this.type.hashCode();
    }

    /**
     * 在 {@link MoreTypes#canonicalize(Type)} 中从超类的类型参数返回类型
     * @param subclass
     * @return
     */
    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            // 抛出失踪的参数类型
            throw new NestedRuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return parameterized;
    }

    /**
     * 从超类的类型参数中获取 type literal
     * @param subclass
     * @return
     */
    static TypeLiteral<?> fromSupperclassTypeParameter(Class<?> subclass) {
        return new TypeLiteral<>(getSuperclassTypeParameter(subclass));
    }

    /**
     * 返回此类型的原始类型(非泛型)
     * @return
     */
    public final Class<? super T> getRawType() {
        return rawType;
    }

    /**
     * 获取 {@code Type} 的底层实例
     * @return
     */
    public final Type getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TypeLiteral<?> && MoreTypes.equals(type, ((TypeLiteral)o).type);
    }

    @Override
    public String toString() {
        return MoreTypes.typeToString(type);
    }

    public static TypeLiteral<?> get(Type type) {
        return new TypeLiteral<>(type);
    }

    private List<TypeLiteral<?>> resolveAll(Type[] types) {
        TypeLiteral<?>[] result =new TypeLiteral<?>[types.length];
        for (int t = 0; t < types.length; t++) {
            result[t] = resolve(types[t]);
        }
        return ImmutableList.of(result);
    }

    TypeLiteral<?> resolve(Type toResolve) {
        return TypeLiteral.get(resolveType(toResolve));
    }

    Type resolveType(Type toResolve) {

        while (true) {
            if (toResolve instanceof TypeVariable) {
                TypeVariable original = (TypeVariable) toResolve;
                toResolve = MoreTypes.resolveTypeVariable(type, rawType, original);
                if (toResolve == original) {
                    return toResolve;
                }
            } else if (toResolve instanceof GenericArrayType) {
                GenericArrayType original = (GenericArrayType) toResolve;
                Type componentType = original.getGenericComponentType();
                Type newComponentType = resolveType(componentType);
                return componentType == newComponentType ? original : Types.arrayOf(newComponentType);

            }
            return toResolve;
        }
    }
}
