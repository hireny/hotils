package org.hotilsframework.core;

/**
 * Order
 *
 * Interface for objects that are ordered.
 *
 * 为有序对象提供接口
 *
 * @author hireny
 * @date 2020-04-10 15:52
 */
public interface Ordered<T> extends Comparable<T> {
    /**
     * Constant for the highest precedence value.
     *
     * 常数，以获得最高优先级值。
     */
    int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;
    /**
     * Constant for the lowest precedence value.
     *
     * 常数，以获取最低优先级值。
     */
    int LOWEST_PRECEDENCE = Integer.MAX_VALUE;

    /**
     * The order of the object. Defaults to zero (no order).
     *
     * 获取对象顺序。默认值为零（无顺序）
     *
     * @return  返回对象顺序值
     */
    default int getOrder() {
        return 0;
    }
}
