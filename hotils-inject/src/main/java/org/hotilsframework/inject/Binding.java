package org.hotilsframework.inject;

/**
 * 绑定的元素
 * @author hireny
 * @className Binding
 * @create 2020-05-15 22:40
 */
public interface Binding<T> {
    /**
     * 获取绑定元素的Key
     * @return
     */
    Object getKey();

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
