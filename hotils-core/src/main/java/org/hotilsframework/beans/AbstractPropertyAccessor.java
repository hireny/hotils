package org.hotilsframework.beans;

import java.util.Map;

/**
 * @ClassName: AbstractPropertyAccessor
 * @Author: hireny
 * @Date: Created in 2020-02-01 23:04
 * @Version: 1.0
 */
public abstract class AbstractPropertyAccessor implements PropertyAccessor {

    @Override
    public Class<?> getPropertyType(String propertyName) {
        return null;
    }

    @Override
    public abstract Object getPropertyValue(String propertyName) throws BeansException;

    @Override
    public void setPropertyValue(String propertyName, Object value) throws BeansException {

    }

    @Override
    public void setPropertyValue(PropertyValue propertyValue) throws BeansException {

    }

    @Override
    public void setPropertyValues(Map<?, ?> map) throws BeansException {

    }

    @Override
    public void setPropertyValues(PropertyValues pvs) throws BeansException {

    }
}
