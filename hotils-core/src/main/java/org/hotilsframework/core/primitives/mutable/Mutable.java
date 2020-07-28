package org.hotilsframework.core.primitives.mutable;

/**
 * @author hireny
 * @className Mutable
 * @create 2020-03-12 23:30
 */
public interface Mutable<T> {
    /**
     * 获取这个可变的值
     * @return  存储的值
     */
    T getValue();

    /**
     * 设置这个可变的值
     * @param value
     *              要存储的值
     * @throws NullPointerException
     *              如果对象为空且空无效抛出此异常
     * @throws ClassCastException
     *              如果类型无效抛出此异常
     */
    void setValue(T value);
}
