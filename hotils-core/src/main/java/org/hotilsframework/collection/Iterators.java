package org.hotilsframework.collection;

import java.util.Iterator;

/**
 * 迭代器工具类
 * @ClassName: IteratorUtils
 * @Author: hireny
 * @Date: Created in 2020-02-09 14:23
 * @Version: 1.0
 */
public final class Iterators {

    /**
     * Iterable是否为空
     * @param iterable  Iterable对象
     * @return          是否为空
     */
    public static boolean isEmpty(Iterable<?> iterable) {
        return null == iterable || isEmpty(iterable.iterator());
    }

    /**
     * Iterator迭代器是否为空
     * @param iterator  Iterator对象
     * @return          是否为空
     */
    public static boolean isEmpty(Iterator<?> iterator) {
        return null == iterator || !iterator.hasNext();
    }

    /**
     * 是否包含 {@code null}元素
     * @param iterable  被检查的 {@link Iterable}对象，如果为{@code null} 返回true
     * @return
     */
    public static boolean hasNull(Iterable<?> iterable) {
        return hasNull(iterable.iterator());
    }

    /**
     * 是否包含 {@code null}元素
     * @param iterator  被检查的 {@link Iterator}对象，如果为{@code null} 返回true
     * @return          是否包含 {@code null} 元素
     */
    public static boolean hasNull(Iterator<?> iterator) {
        if (null == iterator) {
            return true;
        }
        while (iterator.hasNext()) {
            if (null == iterator.next()) {
                return true;
            }
        }
        return false;
    }
}
