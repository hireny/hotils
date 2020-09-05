package org.hotilsframework.beans;

import org.hotilsframework.collect.Maps;
import org.hotilsframework.lang.primitives.Booleans;
import org.hotilsframework.lang.Assert;
import org.hotilsframework.lang.reflects.ModifierUtils;
import org.hotilsframework.lang.reflects.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Bean描述器
 * @ClassName: BeanDescriptor
 * @Author: hireny
 * @Date: Created in 2020-02-07 0:11
 * @Version: 1.0
 */
public interface BeanDescriptor {
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
     * 获取Bean字段描述
     * @param propertyName
     * @return
     * @throws InvalidPropertyException
     */
    PropertyDescriptor getPropertyDescriptor(String propertyName) throws InvalidPropertyException;


    class DefaultBeanDescriptor implements BeanDescriptor {

        private static final long serialVersionUID = -3785884359066440601L;

        /**
         * bean类
         */
        private final Class<?> targetClass;

        private final Map<String, PropDescriptor> propDescriptorMap = Maps.newLinkedHashMap();

        /**
         * 构造
         * @param beanClass
         */
        public DefaultBeanDescriptor(Class<?> beanClass) {
            this.targetClass = Assert.notNull(beanClass);
        }

        /**
         * 初始化
         * 只有与属性关联的相关Getter和Setter方法才会被读取，无关的getter和setter都被忽略
         * @return
         */
        private DefaultBeanDescriptor init() {
            for (Field field : ReflectionUtils.getFields(targetClass)) {
                if (false == ModifierUtils.isStatic(field)) {
                    // 只针对非static属性
                    this.propDescriptorMap.put(field.getName(), createPropDescriptor(field));
                }
            }
            return this;
        }

        private PropDescriptor createPropDescriptor(Field field) {
            final String fieldName = field.getName();
            final Class<?> fieldType = field.getType();
            final boolean isBooleanField = Booleans.isBoolean(fieldType);

            Method getter = null;
            Method setter = null;

            String methodName;
            Class<?>[] parameterTypes;

            return null;
        }

        @Override
        public Object getBeanInstance() {
            return null;
        }

        @Override
        public Class<?> getBeanClass() {
            return null;
        }

        @Override
        public PropertyDescriptor[] getPropertyDescriptors() {
            return new PropertyDescriptor[0];
        }

        @Override
        public PropertyDescriptor getPropertyDescriptor(String propertyName) throws InvalidPropertyException {
            return null;
        }
    }

    /**
     * 属性描述
     *
     * @author hireny
     */
    class PropDescriptor {
        /**
         * 字段
         */
        private final Field field;
        /**
         * Getter方法
         */
        private final Method getter;
        /**
         * Setter方法
         */
        private final Method setter;

        /**
         * 构造
         *
         * @param field  字段
         * @param getter getter方法
         * @param setter setter方法
         */
        public PropDescriptor(Field field, Method getter, Method setter) {
            this.field = field;
            this.getter = getter;
            this.setter = setter;
        }

        /**
         * 获取字段名
         *
         * @return 字段名
         */
        public String getFieldName() {
            return null == this.field ? null : this.field.getName();
        }

        /**
         * 获取字段
         *
         * @return 字段
         */
        public Field getField() {
            return this.field;
        }


        /**
         * 获取Getter方法，可能为{@code null}
         *
         * @return Getter方法
         */
        public Method getGetter() {
            return this.getter;
        }

        /**
         * 获取Setter方法，可能为{@code null}
         *
         * @return {@link Method}Setter 方法对象
         */
        public Method getSetter() {
            return this.setter;
        }

        //------------------------------------------------------------------------------------ Private method end
    }
}
