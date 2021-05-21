package org.hotilsframework.core.match;

/**
 * Matcher
 *
 * 匹配器接口
 *
 * @author hireny
 * @date: Create in 2019/12/10 00:19
 *
 * @param <T>   匹配的对象类型
 */
@FunctionalInterface
public interface Matcher<T> {
    /**
     * 给定对象是否匹配
     * @param t     对象
     * @return      是否匹配
     */
    boolean match(T t);
}
