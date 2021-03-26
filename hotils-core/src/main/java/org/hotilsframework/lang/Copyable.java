package org.hotilsframework.lang;

/**
 * 克隆接口
 * @className Cloneable
 * @author hireny
 * @date Created in 2020-01-31 13:02
 */
@FunctionalInterface
public interface Copyable<T>  {
    /**
     * 执行拷贝
     * @return  拷贝的目标
     */
    T copy();
}
