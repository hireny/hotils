package org.hotilsframework.beans;

import java.beans.PropertyDescriptor;
import java.io.Serializable;

/**
 * @author hireny
 * @className BeanWrapper
 * @create 2020-04-08 10:13
 */
public interface BeanWrapper extends Serializable {
    /**
     * 获取包装的实例
     * @return
     */
    Object getWrappedInstance();

    /**
     * 获取包装的类型
     * @return
     */
    Class<?> getWrappedClass();

    /**
     * 获取bean字段描述符的数组
     * @return
     */
    PropertyDescriptor[] getPropertyDescriptors();

    /**
     * 获取Bean字段的属性值
     * @param propertyName
     * @return
     */
    PropertyDescriptor getProertyValue(String propertyName);
}
