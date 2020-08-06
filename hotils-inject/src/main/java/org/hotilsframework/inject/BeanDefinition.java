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
     * 获取该Bean定义的父Bean定义
     * @return
     */
    BeanDefinition getParent();
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
     * 返回该Bean是否是抽象的，也意味着该Bean是否不用被实例化
     * @return
     */
    boolean isAbstract();

    /**
     * 是否懒加载，即不在启动时急于实例化，只适用于类似于单例作用域的。
     * @return
     */
    boolean islazyInit();

    /**
     * 获取Bean的作用域
     * @return
     */
    Class<? extends Annotation> getScope();
}
