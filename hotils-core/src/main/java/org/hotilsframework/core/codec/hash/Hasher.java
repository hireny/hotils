package org.hotilsframework.core.codec.hash;

/**
 * Hasher
 * 类描述
 *
 * @author hireny
 * @create 2020-07-14 9:47
 */
public interface Hasher extends PrimitiveSink {

    /**
     * 添加一个对象数据源
     * @param instance
     * @param funnel
     * @param <T>
     * @return
     */
    <T> Hasher put(T instance, Funnel<? extends T> funnel);

    /**
     * 获取到HashCode
     * @return
     */
    HashCode hash();
}
