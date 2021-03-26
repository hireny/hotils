package org.hotilsframework.core.types;

import org.hotilsframework.lang.Assert;

import java.io.Serializable;

/**
 * ArgumentValue
 *
 * 参数值
 *
 * @author hireny
 * @create 2020-11-16 20:43
 */
public class ArgumentValue implements Serializable {
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

    public ArgumentValue(String name, Object value) {
        // name不能为空
        Assert.notNull(name, "Name must not be null.");
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
        return "ArgumentValue{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
