package org.hotilsframework.inject.binding;


/**
 * InstanceBinding
 *
 * 实例化绑定
 *
 * @author hireny
 * @create 2020-08-07 0:06
 */
public interface InstanceBinding<T> extends Binding<T> {
    /**
     * Returns the user-supplied instance.
     *
     * 返回用户提供的实例
     * @return
     */
    T getInstance();
}
