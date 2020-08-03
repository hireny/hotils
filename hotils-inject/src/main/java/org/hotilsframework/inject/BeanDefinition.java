package org.hotilsframework.inject;

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
     * 获取Bean定义的类型
     * @return
     */
    Class<?> getType();

    /**
     * 获取名称
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
}
