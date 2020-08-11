package org.hotilsframework.inject;

import org.hotilsframework.inject.factory.config.Scope;

/**
 * 将键值进行绑定的绑定元素
 * @author hireny
 * @className Binding
 * @create 2020-05-15 22:40
 */
public interface Binding<T> {
    /**
     * 获取绑定元素的Key
     * @return
     */
    Key<T> getKey();

    /**
     * 获取提供者
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
     * 绑定Key键
     * @param key
     * @return
     */
    Binding<T> withKey(Key<T> key);

    /**
     * 是否常量绑定，就是常量绑定或者 toInstance()绑定，该方法都返回true。
     * @return
     */
    boolean isConstant();
}
