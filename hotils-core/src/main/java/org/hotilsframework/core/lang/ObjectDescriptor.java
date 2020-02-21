package org.hotilsframework.core.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 对象描述符<br>
 *
 * 用于描述对象的信息
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:36
 */
public final class ObjectDescriptor implements Wrapper {

    private static final long serialVersionUID = 8966302421474564907L;
    private Object target;
    private Class<?> targetClass;
    private Type targetType;
    private Field[] fields;
    private Constructor<?>[] constructors;
    private Method[] methods;
    private Class<?> extendsClass;

    private Class<?> implementsClasses;

    private Field[] staticFields;

    private Method[] staticMethods;

    private ObjectDescriptor(Object o) {
        this.target = o;
        this.targetClass = o.getClass();
    }


    @Override
    public Object getTarget() {
        return this.target;
    }

    @Override
    public Class<?> getTargetClass() {
        return this.targetClass;
    }

    public static ObjectDescriptor of(Object t) {
        return new ObjectDescriptor(t);
    }
}
