package org.hotilsframework.core.types;

import org.hotilsframework.collect.Lists;

import java.util.List;

/**
 * 装载PropertyValue属性值的集合类
 * @ClassName: PropertyValues
 * @Author: hireny
 * @Date: Created in 2020-01-30 20:34
 * @Version: 1.0
 */
public class ArgumentValues {

    private final List<ArgumentValue> propertyValues;

    public ArgumentValues() {
        this(Lists.newArrayList());
    }

    public ArgumentValues(List<ArgumentValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public List<ArgumentValue> getPropertyValues() {
        return propertyValues;
    }

    public boolean addPropertyValue(ArgumentValue propertyValue) {
        for (int i=0; i < this.propertyValues.size(); i++) {
            ArgumentValue currentPv = this.propertyValues.get(i);
            if (currentPv.equals(propertyValue)) {
                // 缺少合并方法   pv = mergeIfRequired(pv, currentPv);
                setPropertyValueAt(propertyValue, i);
                return true;
            }
        }
        return propertyValues.add(propertyValue);
    }

    public boolean addPropertyValue(String propertyName, Object propertyValue) {

        return addPropertyValue(new ArgumentValue(propertyName, propertyValue));
    }

    /**
     * Modify a PropertyValue object held in this object.
     * Indexed from 0.
     */
    public void setPropertyValueAt(ArgumentValue pv, int i) {
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
