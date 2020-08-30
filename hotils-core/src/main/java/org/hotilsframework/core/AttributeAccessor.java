package org.hotilsframework.core;

import org.hotilsframework.lang.Nullable;

/**
 * 属性访问器
 * 接口，定义用于向任意对象附加和访问元数据的通用契约。
 * @author hireny
 * @className AttributeAccessor
 * @create 2020-04-08 12:25
 */
public interface AttributeAccessor {

    /**
     * 将名为 {@code name} 的属性设置为 {@code value}
     *
     * @param name      唯一的属性键
     * @param value     要赋值的属性值
     */
    void setAttribute(String name, @Nullable Object value);

    /**
     * 根据唯一的属性键 {@code name} 获取 属性值
     * @param name      唯一的属性键
     * @return          返回的 {@code name} 属性键的属性值
     */
    @Nullable
    Object getAttribute(String name);

    /**
     * 删除有 {@code name} 标识的属性并返回其属性值
     * @param name      唯一的属性键
     * @return
     */
    @Nullable
    Object removeAttribute(String name);

    /**
     * 如果 {@code name} 标识的属性存在，则返回 {@code true}，否则返回 {@code false}
     * @param name      唯一的属性键
     * @return
     */
    boolean hasAttribute(String name);

    /**
     * 返回所有属性的名称
     * @return
     */
    String[] attributeNames();
}
