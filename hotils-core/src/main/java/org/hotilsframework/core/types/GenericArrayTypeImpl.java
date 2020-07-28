package org.hotilsframework.core.types;

import org.hotilsframework.core.reflects.CompositeType;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/**
 * @author hireny
 * @className GenericArrayTypeImpl
 * @create 2020-06-17 21:14
 */
public class GenericArrayTypeImpl implements GenericArrayType, Serializable, CompositeType {
    private static final long serialVersionUID = -1483265097728987041L;

    private final Type componentType;

    public GenericArrayTypeImpl(Type componentType) {
        this.componentType = componentType;
    }

    @Override
    public Type getGenericComponentType() {
        return componentType;
    }

    @Override
    public boolean isFullySpecified() {
        return MoreTypes.isFullySpecified(componentType);
    }

    @Override
    public int hashCode() {
        return componentType.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GenericArrayType && MoreTypes.equals(this, (GenericArrayType) o);
    }

    @Override
    public String toString() {
        return MoreTypes.typeToString(componentType) + "[]";
    }
}
