package org.hotilsframework.lang.hash;

/**
 * Funnel
 * 类描述
 *
 * @author hireny
 * @create 2020-07-14 9:50
 */
public interface Funnel<T> {
    /**
     * Sends a stream of data from the {@code from} object into the sink {@code into}.
     * There is no requirement that this data be complete enough to fully reconstitute the object later.
     *
     * 将数据流从 {@code from} 对象发送接收器 {@code into}
     *
     * @param from
     * @param into
     */
    void funnel(T from, PrimitiveSink into);
}
