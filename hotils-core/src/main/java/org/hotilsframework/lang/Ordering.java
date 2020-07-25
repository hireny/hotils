package org.hotilsframework.lang;

import java.util.Comparator;

/**
 * 排序
 * @author hireny
 * @className Ordering
 * @create 2020-07-04 7:35
 */
public abstract class Ordering<T> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        if (o1 == o2) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }
        return 0;
    }
}
