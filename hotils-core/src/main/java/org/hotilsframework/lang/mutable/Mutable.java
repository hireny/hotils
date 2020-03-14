package org.hotilsframework.lang.mutable;

/**
 * @author hireny
 * @className Mutable
 * @create 2020-03-12 23:30
 */
public interface Mutable<T> {
    /**
     * 获取这个可变类的值
     * @return
     */
    T getValue();

    /**
     * 设置这个可变类的值
     * @param value
     *
     * @throws NullPointerException
     *
     * @throws ClassCastException
     */
    void setValue(T value);
}
