package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.BeanKey;
import org.hotilsframework.inject.Scope;

import java.lang.annotation.Annotation;

/**
 * 范围
 * @author hireny
 * @className Scope
 * @create 2020-04-01 20:18
 */
public interface Scoping extends Scope {

    /**
     * 注册Bean元素
     * @param beanKey
     * @param element
     */
    void register(BeanKey<?> beanKey, Object element);

    /**
     * 根据指定的键来获取该作用域的对象
     * @param beanKey       键，用来获取该作用域下的提供者
     * @param <T>       泛型
     * @return
     */
    <T> T get(BeanKey<T> beanKey);

    /**
     * 移除作用域中关于键的元素
     * @param beanKey
     * @return
     */
    Object remove(BeanKey<?> beanKey);

    /**
     * 判断该key是否存在
     * @param beanKey
     * @return
     */
    boolean containsKey(BeanKey<?> beanKey);

    /**
     * 获取作用域注解
     * @return
     */
    @Override
    Class<? extends Annotation> getScopeAnnotation();

    /**
     * 返回字符串
     * @return
     */
    @Override
    String toString();


}
