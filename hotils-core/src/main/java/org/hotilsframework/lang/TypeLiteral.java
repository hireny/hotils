package org.hotilsframework.lang;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
        this.rawType = (Class<? super T>) MoreTypes.getRawTYpe(type);
        this.hashCode = type.hashCode();
    }

    @SuppressWarnings("unchecked")
    TypeLiteral(Type type) {
        this.type = MoreTypes.canonicalize(getClass());
        this.rawType = (Class<? super T>) MoreTypes.getRawTYpe(type);
        this.hashCode = this.type.hashCode();
    }


    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            // 抛出失踪的参数类型
            throw new NestedRuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return parameterized;
    }

    public final Class<? super T> getRawType() {
        return rawType;
    }

    public final Type getType() {
        return type;
    }

    public int getHashCode() {
        return hashCode;
    }
}
