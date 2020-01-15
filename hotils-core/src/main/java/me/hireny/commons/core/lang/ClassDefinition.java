package me.hireny.commons.core.lang;

import java.lang.annotation.Annotation;

/**
 * @ClassName: ClassDefinition
 * @Description: TODO   类定义
 * @Author: hireny
 * @Date: Created in 2020-01-08 22:02
 * @Version: 1.0
 */
public interface ClassDefinition {

    String getName();
    String getCanonicalName();

    /**
     * 是否为接口
     * @return
     */
    boolean isInterface();

    int getModifiers();

    /**
     * 获取类所在的包
     * @return
     */
    Package getPackage();

    /**
     * 获取类所有注解
     * @return
     */
    Annotation[] getAnnotations();

    static ClassDefinition of(Class<?> clazz) {
        return new ClassDefinition() {
            @Override
            public String getName() {
                return clazz.getName();
            }

            @Override
            public String getCanonicalName() {
                return clazz.getCanonicalName();
            }

            @Override
            public boolean isInterface() {
                return clazz.isInterface();
            }

            @Override
            public int getModifiers() {
                return clazz.getModifiers();
            }

            @Override
            public Package getPackage() {
                return clazz.getPackage();
            }

            @Override
            public Annotation[] getAnnotations() {
                return clazz.getAnnotations();
            }
        };
    }
}
