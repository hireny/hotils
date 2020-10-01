package org.hotilsframework.core.match;

/**
 * @ClassName: Matcher
 * @Author: hireny
 * @Date: Create in 2019/12/10 00:19
 * @Description: TODO   匹配接口
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
