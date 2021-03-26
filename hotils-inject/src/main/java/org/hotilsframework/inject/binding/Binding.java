package org.hotilsframework.inject.binding;

import org.hotilsframework.inject.BeanKey;
import org.hotilsframework.inject.Provider;
import org.hotilsframework.inject.Scope;

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
    BeanKey<T> getBeanKey();

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
     * @param beanKey
     * @return
     */
    Binding<T> withKey(BeanKey<T> beanKey);

    /**
     * 是否常量绑定，就是常量绑定或者 toInstance()绑定，该方法都返回true。
     * @return
     */
    boolean isConstant();
}
