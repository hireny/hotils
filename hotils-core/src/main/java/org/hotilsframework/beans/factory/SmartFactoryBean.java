package org.hotilsframework.beans.factory;

/**
 * @author hireny
 * @className SmartFactoryBean
 * @create 2020-04-08 9:58
 */
public interface SmartFactoryBean<T> extends FactoryBean<T> {

    /**
     * 判断容器中的实例是否为原型模式
     * @return
     */
    default boolean isPrototype() {
        return false;
    }
}
