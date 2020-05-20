package org.hotilsframework.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 对象包装器
 * 对于对象进行包装，用来获取对象中的类和对象中属性和方法
 * @author hireny
 * @className ObjectWrapper
 * @create 2020-03-29 22:58
 */
public class ObjectWrapper implements Element {
    private static final long serialVersionUID = 8941048882956912133L;

    private Object           target;
    private Class<?>         targetClass;
    private Type             targetType;
    private Field[]          fields;
    private Constructor<?>[] constructors;
    private Method[]         methods;
    private Class<?>         extendsClass;

    private Class<?> implementsClasses;

    private Field[] staticFields;

    private Method[] staticMethods;

    private ObjectWrapper(Object o) {
        this.target = o;
        this.targetClass = o.getClass();
    }


    @Override
    public Object getSource() {
        return this.target;
    }

    @Override
    public Class<?> getSourceType() {
        return this.targetClass;
    }

    public static ObjectWrapper of(Object t) {
        return new ObjectWrapper(t);
    }
}
