package org.hotilsframework.inject;

/**
 * 将键值进行绑定的绑定元素
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
     * 获取作用域
     * @return
     */
    Scope getScope();

    /**
     * 绑定注解
     * @param scope
     * @return
     */
    Binding<T> withScope(Scope scope);

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
