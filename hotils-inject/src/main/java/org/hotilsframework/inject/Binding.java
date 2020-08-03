package org.hotilsframework.inject;

import org.hotilsframework.lang.Element;

/**
 * 将Bean元素通过键值进行绑定
 * @author hireny
 * @className Binding
 * @create 2020-05-15 22:40
 */
public interface Binding<T> extends BeanElement {
    /**
     * 获取绑定元素的Key
     * @return
     */
    Key<T> getKey();

    /**
     * 获取绑定元素的Value
     * @return
     */
    Value<? extends T> getValue();

    /**
     * 获取绑定的Bean
     * @return
     */
    Provider<T> getProvider();

    /**
     * 绑定目标访问
     * @param <V>
     * @return
     */
    <V> V acceptTargetVisitor();

    /**
     * 绑定范围访问
     * @param <V>
     * @return
     */
    <V> V acceptScopingVisitor();
}
