package org.hotilsframework.beans;

import java.util.Map;

/**
 * 属性访问接口
 * @ClassName: PropertyAccessor
 * @Author: hireny
 * @Date: Created in 2020-02-01 22:59
 * @Version: 1.0
 */
public interface PropertyAccessor {

    /**
     * 获取属性类型
     * @param propertyName              属性名
     * @return                          返回属性类型
     */
    Class<?> getPropertyType(String propertyName);

    /**
     * 获取属性值
     * @param propertyName              属性名
     * @return                          返回属性值
     * @throws BeansException           异常
     */
    Object getPropertyValue(String propertyName) throws BeansException;

    /**
     * 设置属性值
     * @param propertyName              属性名
     * @param value                     属性值
     * @throws BeansException           异常
     */
    void setPropertyValue(String propertyName, Object value) throws BeansException;

    /**
     * 设置属性值
     * @param propertyValue             属性名
     * @throws BeansException           异常
     */
    void setPropertyValue(PropertyValue propertyValue) throws BeansException;

    /**
     * 设置属性值
     * @param map
     * @throws BeansException
     */
    void setPropertyValues(Map<?, ?> map) throws BeansException;

    /**
     * 设置属性值
     * @param pvs
     * @throws BeansException
     */
    void setPropertyValues(PropertyValues pvs) throws BeansException;
}
