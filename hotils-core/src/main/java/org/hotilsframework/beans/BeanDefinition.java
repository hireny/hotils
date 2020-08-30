package org.hotilsframework.beans;

import org.hotilsframework.beans.factory.BeanScope;
import org.hotilsframework.core.AttributeAccessor;
import org.hotilsframework.lang.Nullable;

/**
 * @author hireny
 * @className BeanDefinition
 * @create 2020-04-08 12:16
 */
public interface BeanDefinition<T> extends AttributeAccessor, BeanMetadataElement {

    /**
     * 设置父类名称
     * @param parentName
     */
    void setParentName(@Nullable String parentName);

    /**
     * 获取父类名称
     * @return
     */
    @Nullable
    String getParentName();

    /**
     * 设置Bean类名称
     * @param beanClassName
     */
    void setBeanClassName(@Nullable String beanClassName);

    /**
     * 获取Bean类名称
     * @return
     */
    @Nullable
    String getBeanClassName();

    /**
     * 设置Bean类
     * @param beanClass
     */
    void setBeanClass(@Nullable Class<?> beanClass);

    /**
     * 获取Bean类
     * @return
     */
    Class<?> getBeanClass();

    /**
     * 设置Bean类的范围
     * @param scope
     */
    void setScope(@Nullable BeanScope scope);

    /**
     * 返回Bean类的范围
     * @return
     */
    @Nullable
    String getScope();

    /**
     * 设置懒加载
     * @param lazyInit  懒加载的boolean值，true为懒加载开启，false为懒加载关闭
     */
    void setLazyInit(boolean lazyInit);

    /**
     * 返回是否开启懒加载
     * @return
     */
    boolean isLazyInit();


    /**
     * 是否是单例模式
     * @return
     */
    boolean isSingleton();

    /**
     * 是否是原型模式
     * @return
     */
    boolean isPrototype();

    /**
     * Return whether this bean is "abstract", that is, not meant to be instantiated.
     */
    boolean isAbstract();

    /**
     * Return a description of the resource that this bean definition
     * came from (for the purpose of showing context in case of errors).
     */
    @Nullable
    String getResourceDescription();

    /**
     * Return the originating BeanDefinition, or {@code null} if none.
     * Allows for retrieving the decorated bean definition, if any.
     * <p>Note that this method returns the immediate originator. Iterate through the
     * originator chain to find the original BeanDefinition as defined by the user.
     */
    @Nullable
    BeanDefinition getOriginatingBeanDefinition();
}
