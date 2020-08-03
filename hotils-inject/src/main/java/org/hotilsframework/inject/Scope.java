package org.hotilsframework.inject;

/**
 * 范围
 * @author hireny
 * @className Scope
 * @create 2020-04-01 20:18
 */
public interface Scope {
    /**
     * 范围提供者，根据Key与Provider返回该Key的范围的对象
     * @param key
     * @param unscoped
     * @param <T>
     * @return
     */
    <T> Provider<T> scope(Class<?> key, Provider<T> unscoped);

    /**
     * 返回字符串
     * @return
     */
    @Override
    String toString();
}
