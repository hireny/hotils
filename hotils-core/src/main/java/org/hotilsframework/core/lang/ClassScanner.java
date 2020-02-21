package org.hotilsframework.core.lang;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * 类扫描接口
 * @ClassName: ClassScanner
 * @Author: hireny
 * @Date: Created in 2020-02-10 13:59
 * @Version: 1.0
 */
public interface ClassScanner {

    /**
     * 获取指定包名中的所有类
     * @param packageName
     * @param packagePattern
     * @return
     */
    Set<Class<?>> getClassList(String packageName, String packagePattern);

    /**
     * 自定义ClassLoader中获取指定包名中的所有类
     * @param packageName
     * @param packagePattern
     * @param classLoader
     * @return
     */
    Set<Class<?>> getClassList(String packageName, String packagePattern, ClassLoader classLoader);

    /**
     * 获取指定包名中指定注解的相关类
     * @param packageName
     * @param annotationClass
     * @return
     */
    Set<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass);

    /**
     * 自定义ClassLoader中获取指定包名中指定注解的相关类
     * @param packageName
     * @param annotationClass
     * @param classLoader
     * @return
     */
    Set<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass, ClassLoader classLoader);

    /**
     * 获取指定包名中指定父类或接口的相关类
     *
     * @param packageName packageName
     * @param superClass superClass
     * @return Set
     */
    Set<Class<?>> getClassListBySuper(String packageName, Class<?> superClass);

    /**
     * 自定义ClassLoader中获取指定包名中指定父类或接口的相关类
     *
     * @param packageName packageName
     * @param superClass superClass
     * @param classLoader classLoader
     * @return Set
     */
    Set<Class<?>> getClassListBySuper(String packageName, Class<?> superClass, ClassLoader classLoader);
}
