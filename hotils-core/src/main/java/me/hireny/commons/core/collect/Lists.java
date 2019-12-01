package me.hireny.commons.core.collect;

import me.hireny.commons.utils.Assert;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: Lists
 * @Author: hireny
 * @Date: Create in 2019/11/05 14:38
 * @Description: TODO
 */
public final class Lists {

    private Lists() {}

    /**
     * 创建ArrayList
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <E> Stack<E> newStack() {
        return new Stack<>();
    }

    public static <E>CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    public static <E> List<E> asList(E key, E[] rest) {
        return new OneDimensional<>(key, rest);
    }

    /**
     * 一维数组列表
     * @param <E>
     * @see Lists#asList(Object, Object[])
     */
    private static class OneDimensional<E> extends AbstractList<E>
            implements Serializable, RandomAccess {

        final E key;
        final E[] rest;

        public OneDimensional(E key, E[] rest) {
            this.key = key;
            this.rest = Assert.checkNotNull(rest);
        }

        @Override
        public E get(int index) {
            return (index == 0) ? key : rest[index-1];
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
