package org.hotilsframework.beans;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Bean包装器
 * @ClassName: BeanWrapper
 * @Author: hireny
 * @Date: Created in 2020-02-01 22:46
 * @Version: 1.0
 */
public class BeanWrapper implements Serializable {
    private static final long serialVersionUID = -5169341437810067661L;

    private final Object target;
    private final Class<?> targetClass;

    public BeanWrapper(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }


    /**
     * 获取Bean的实例
     * @return
     */
    public Object getBeanInstance() {
        return this.target;
    }

    public Class<?> getBeanClass() {
        return this.targetClass;
    }

    /**
     * 设置Bean字段属性值
     * @param propertyName
     * @param value
     */
    public void setPropertyValue(String propertyName, Object value) {

    }

    /**
     * 获取Bean字段的属性值
     * @param propertyName
     * @return
     */
    public Object getProertyValue(String propertyName) {
        // 获取对象的类型
        Class<?> clazz = target.getClass();
        // 获取 clazz 类型中 propertyName 的属性描述器
        PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(clazz, propertyName);
        // 从属性描述其中获取 get 方法
        Method getter = propertyDescriptor.getReadMethod();
        Object value = null;
        try {
            // 调用方法获取方法的返回值
            value = getter.invoke(clazz);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new BeansException(e);
        }
        // 返回值
        return value;
    }

    public static BeanWrapper of(Object source) {
        return new BeanWrapper(source, source.getClass());
    }
}
