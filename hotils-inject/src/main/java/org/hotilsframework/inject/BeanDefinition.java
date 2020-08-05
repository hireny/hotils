package org.hotilsframework.inject;

import org.hotilsframework.lang.Optional;

import java.lang.annotation.Annotation;

/**
 * BeanDefinition
 *
 * Bean定义
 *
 * @author hireny
 * @create 2020-08-01 20:01
 */
public interface BeanDefinition {
    /**
     * 获取定义的类型
     * @return
     */
    Class<?> getType();

    /**
     * 获取类的名称
     * @return
     */
    String getName();

    /**
     * 获取实例
     * @return
     */
    Object get();

    /**
     * 是否是单例模式
     * @return
     */
    boolean isSingleton();

    /**
     * 是否是原型模式(每次请求都新创建)
     * @return
     */
    boolean isPrototype();

    /**
     * 获取Bean的作用域
     * @return
     */
    Optional<Class<? extends Annotation>> getScope();
}
