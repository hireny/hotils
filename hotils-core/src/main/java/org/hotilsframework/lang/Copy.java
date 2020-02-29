package org.hotilsframework.lang;

/**
 * 拷贝接口
 * @ClassName: Copier
 * @Author: hireny
 * @Date: Created in 2020-01-31 13:02
 * @Version: 1.0
 */
@FunctionalInterface
public interface Copy<T> {
    /**
     * 执行拷贝
     * @return  拷贝的目标
     */
    T copy();
}
