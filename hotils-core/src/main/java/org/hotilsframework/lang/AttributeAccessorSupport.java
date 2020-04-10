package org.hotilsframework.lang;

import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.CollectionUtils;
import org.hotilsframework.utils.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hireny
 * @className AttributeAccessorSupport
 * @create 2020-04-08 12:33
 */
public abstract class AttributeAccessorSupport implements AttributeAccessor {

    /**
     * 使用 string 键 和 object 值 进行映射
     */
    private final Map<String, Object> attributes = new LinkedHashMap<>();

    @Override
    public void setAttribute(String name, Object value) {
        Assert.notNull(name, "Name must not be null");
        if (value != null) {
            this.attributes.put(name, value);
        } else {
            removeAttribute(name);
        }
    }

    @Override
    @Nullable
    public Object getAttribute(String name) {
        Assert.notNull(name, "Name must not be null");
        return this.attributes.get(name);
    }

    @Override
    public Object removeAttribute(String name) {
        Assert.notNull(name, "Name must not be null");
        return this.attributes.remove(name);
    }

    @Override
    public boolean hasAttribute(String name) {
        Assert.notNull(name, "Name must not be null");
        return this.attributes.containsKey(name);
    }

    @Override
    public String[] attributeNames() {
        return CollectionUtils.toArray(this.attributes.keySet(), String.class);
    }

    @Override
    public int hashCode() {
        return this.attributes.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AttributeAccessorSupport) {
            return this.attributes.equals(((AttributeAccessorSupport) other).attributes);
        }
        return false;
    }

    /**
     * 将属性从 {@code source} 复制到此访问器
     * @param source        来源
     */
    protected void copyAttributesFrom(AttributeAccessor source) {
        Assert.notNull(source, "Source must not be null");
        String[] attributeNames = source.attributeNames();
        for (String attributeName : attributeNames) {
            setAttribute(attributeName, source.getAttribute(attributeName));
        }
    }
}
