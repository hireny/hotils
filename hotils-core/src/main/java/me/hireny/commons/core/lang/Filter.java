package me.hireny.commons.core.lang;

/**
 * @ClassName: Filter
 * @Author: hireny
 * @Date: Create in 2019/12/08 00:33
 * @Description: TODO   过滤器接口
 */
@FunctionalInterface
public interface Filter<T> {
    /**
     * 是否接受对象
     * @param t 检查的对象
     * @return  是否接受对象
     */
    boolean accept(T t);
}
