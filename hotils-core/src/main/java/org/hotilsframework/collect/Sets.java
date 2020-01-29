package org.hotilsframework.collect;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 集合操作
 * @ClassName: Sets
 * @Author: hireny
 * @Date: Created in 2020-01-16 0:04
 * @Version: 1.0
 */
public final class Sets {
    private Sets() {}

    //****************************创建HashSet***************************************//

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    //****************************创建TreeSet***************************************//

    public static <E> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }
}
