package org.hotilsframework.beans;

import java.beans.PropertyDescriptor;

/**
 * Bean包装
 * @ClassName: BeanWrapper
 * @Author: hireny
 * @Date: Created in 2020-02-01 22:46
 * @Version: 1.0
 */
public interface BeanWrapper {

    /**
     * 获取Bean的实例
     * @return
     */
    Object getBeanInstance();

    /**
     * 获取Bean的类
     * @return
     */
    Class<?> getBeanClass();

    /**
     * 获得Bean字段描述数组
     * @return
     */
    PropertyDescriptor[] getPropertyDescriptors();

    /**
     * 获取Bean字段描述数组
     * @param propertyName
     * @return
     * @throws InvalidPropertyException
     */
    PropertyDescriptor getPropertyDescriptor(String propertyName) throws InvalidPropertyException;
}
