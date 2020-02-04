package org.hotilsframework.beans;

import org.hotilsframework.pools.Validator;
import org.hotilsframework.utils.Assert;

import java.io.Serializable;

/**
 * 属性值的类，装载一个bean中的属性的键值对
 * @ClassName: PropertyValue
 * @Author: hireny
 * @Date: Created in 2020-01-30 20:28
 * @Version: 1.0
 */
public class PropertyValue implements Serializable {
    private static final long serialVersionUID = -8824705865183646976L;

    /**
     * 属性的键，例如：String username
     * username即是name的值
     */
    private final String name;

    /**
     * 属性的值，例如：String username = "admin"；
     * admin即是value的值
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        // name不能为空
        Assert.checkNotNull(name, "Name must not be null.");
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
