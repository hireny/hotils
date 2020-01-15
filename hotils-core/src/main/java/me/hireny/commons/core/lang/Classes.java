package me.hireny.commons.core.lang;

import java.lang.annotation.Annotation;

/**
 * Classes
 * 对Class类进行增强
 * @Author: hireny
 * @Date: Create in 2019/10/03 22:29
 */
public class Classes implements ClassDefinition {

    private Class<?> clazz;

    public static ClassDefinition of(Class<?> clazz) {
        return new Classes(clazz);
    }

    private Classes(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getName() {
        return this.clazz.getName();
    }

    @Override
    public String getCanonicalName() {
        return this.clazz.getCanonicalName();
    }

    @Override
    public boolean isInterface() {
        return this.clazz.isInterface();
    }

    @Override
    public int getModifiers() {
        return this.clazz.getModifiers();
    }

    @Override
    public Package getPackage() {
        return this.clazz.getPackage();
    }

    @Override
    public Annotation[] getAnnotations() {
        return this.clazz.getAnnotations();
    }
}
