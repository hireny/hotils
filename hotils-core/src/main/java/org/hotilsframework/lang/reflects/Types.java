package org.hotilsframework.lang.reflects;

import org.hotilsframework.core.types.GenericArrayTypeImpl;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/**
 * @author hireny
 * @className Types
 * @create 2020-06-17 21:09
 */
public final class Types {
    private Types() {}


    public static GenericArrayType arrayOf(Type componentType) {
        return new GenericArrayTypeImpl(componentType);
    }
}
