package org.hotilsframework.core.collection;

import org.hotilsframework.utils.ArrayUtils;
import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.CollectionUtils;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: Lists
 * @Author: hireny
 * @Date: Create in 2019/11/05 14:38
 * @Description: TODO   列表
 */
public final class Lists {

    private Lists() {}

    //****************************创建ArrayList***************************************//

    /**
     * 创建ArrayList
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> newArrayList(int initialCapacity) {
        return new ArrayList<>(initialCapacity);
    }

    public static <E> ArrayList<E> newArrayList(Collection<E> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return newArrayList();
        }
        return new ArrayList<>(collection);
    }

    public static <E> ArrayList<E> newArrayList(Iterable<E> iterable) {
        if (null == iterable) {
            return newArrayList();
        }
        return newArrayList(iterable.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<E> iterator) {
        ArrayList<E> arrayList = newArrayList();
        if (null != iterator) {
            while (iterator.hasNext()) {
                arrayList.add(iterator.next());
            }
        }
        return arrayList;
    }

    public static <E> ArrayList<E> newArrayList(Enumeration<E> enumeration) {
        ArrayList<E> arrayList = newArrayList();
        if (null != enumeration) {
            while (enumeration.hasMoreElements()) {
                arrayList.add(enumeration.nextElement());
            }
        }
        return arrayList;
    }

    public static <E> ArrayList<E> newArrayList(E... values) {
        if (ArrayUtils.isEmpty(values)) {
            return newArrayList();
        }
        ArrayList<E> arrayList = newArrayList();
        Collections.addAll(arrayList, values);
        return arrayList;
    }

    //****************************创建LinkedList***************************************//

    /**
     * 创建LinkedList
     * @param <E>
     * @return
     */
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <E> LinkedList<E> newLinkedList(Collection<E> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return newLinkedList();
        }
        return new LinkedList<>(collection);
    }

    public static <E> LinkedList<E> newLinkedList(Iterable<E> iterable) {
        if (null == iterable) {
            return newLinkedList();
        }
        return newLinkedList(iterable.iterator());
    }

    public static <E> LinkedList<E> newLinkedList(Iterator<E> iterator) {
        LinkedList<E> linkedList = newLinkedList();
        if (null != iterator) {
            while (iterator.hasNext()) {
                linkedList.add(iterator.next());
            }
        }
        return linkedList;
    }

    public static <E> LinkedList<E> newLinkedList(Enumeration<E> enumeration) {
        LinkedList<E> linkedList = newLinkedList();
        if (null != enumeration) {
            while (enumeration.hasMoreElements()) {
                linkedList.add(enumeration.nextElement());
            }
        }
        return linkedList;
    }

    public static <E> LinkedList<E> newLinkedList(E... values) {
        if (ArrayUtils.isEmpty(values)) {
            return newLinkedList();
        }
        LinkedList<E> linkedList = newLinkedList();
        Collections.addAll(linkedList, values);

        return linkedList;
    }

    //****************************创建Stack***************************************//

    public static <E> Stack<E> newStack() {
        return new Stack<>();
    }

    //****************************创建CopyOnWriteArrayList***************************************//

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Collection<E> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return newCopyOnWriteArrayList();
        }
        return new CopyOnWriteArrayList<>(collection);
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<E> iterable) {
        if (null == iterable) {
            return newCopyOnWriteArrayList();
        }
        return newCopyOnWriteArrayList(iterable.iterator());
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterator<E> iterator) {
        CopyOnWriteArrayList<E> copyOnWriteArrayList = newCopyOnWriteArrayList();
        if (null != iterator) {
            while (iterator.hasNext()) {
                copyOnWriteArrayList.add(iterator.next());
            }
        }
        return copyOnWriteArrayList;
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Enumeration<E> enumeration) {
        CopyOnWriteArrayList<E> copyOnWriteArrayList = newCopyOnWriteArrayList();
        if (null != enumeration) {
            while (enumeration.hasMoreElements()) {
                copyOnWriteArrayList.add(enumeration.nextElement());
            }
        }
        return copyOnWriteArrayList;
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(E... values) {
        if (ArrayUtils.isEmpty(values)) {
            return newCopyOnWriteArrayList();
        }
        return new CopyOnWriteArrayList<>(values);
    }

    /**
     * 根据集合类型创建集合
     * @param type
     * @param <E>
     * @return
     */
    public static <E> List<E> newList(ListType type) {
        switch (type) {
            case ArrayList:
                return new ArrayList<>();
            case LinkedList:
                return new LinkedList<>();
            case Vector:
                return new Vector<>();
            case STACK:
                return new Stack<>();
            case CopyOnWriteArrayList:
                return new CopyOnWriteArrayList<>();
            default:
                throw new NoSuchListTypeException("no such list type.");
        }
    }

    public static <E> List<E> asList(E key, E[] rest) {
        return new OneDimensional<>(key, rest);
    }

    /**
     * 反转列表
     * @param list          列表
     * @param <T>           反转后的列表
     * @return
     */
    public static <T> List<T> invert(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        List<T> invertList = Lists.newArrayList();
        for (int i = list.size() - 1; i >= 0; i--) {
            invertList.add(list.get(i));
        }
        return invertList;
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
