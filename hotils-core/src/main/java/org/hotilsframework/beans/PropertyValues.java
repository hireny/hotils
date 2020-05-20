package org.hotilsframework.beans;

import org.hotilsframework.core.collect.Lists;

import java.util.List;

/**
 * 装载PropertyValue属性值的集合类
 * @ClassName: PropertyValues
 * @Author: hireny
 * @Date: Created in 2020-01-30 20:34
 * @Version: 1.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues;

    public PropertyValues() {
        this(Lists.newArrayList());
    }

    public PropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public boolean addPropertyValue(PropertyValue propertyValue) {
        for (int i=0; i < this.propertyValues.size(); i++) {
            PropertyValue currentPv = this.propertyValues.get(i);
            if (currentPv.equals(propertyValue)) {
                // 缺少合并方法   pv = mergeIfRequired(pv, currentPv);
                setPropertyValueAt(propertyValue, i);
                return true;
            }
        }
        return propertyValues.add(propertyValue);
    }

    public boolean addPropertyValue(String propertyName, Object propertyValue) {

        return addPropertyValue(new PropertyValue(propertyName, propertyValue));
    }

    /**
     * Modify a PropertyValue object held in this object.
     * Indexed from 0.
     */
    public void setPropertyValueAt(PropertyValue pv, int i) {
        this.propertyValues.set(i, pv);
    }

    /**
     * 判断PropertyValues是否为空
     * @return
     */
    public boolean isEmpty() {
        return (this.propertyValues == null || this.propertyValues.size() == 0);
    }

    @Override
    public String toString() {
        return "PropertyValues{" +
                "propertyValues=" + propertyValues +
                '}';
    }
}
