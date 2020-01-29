package org.hotilsframework.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * 复制 {@link java.util.Iterator}
 *
 * 为了解决并发情况下 {@link java.util.Iterator} 遍历导致的问题（当Iterator被修改会抛出ConcurrentModificationException）
 *
 *
 * <p>
 * 解决方法为：在构造方法中遍历Iterator中的元素，装入新的List中然后遍历之。
 * 当然，修改这个复制后的Iterator是没有意义的，因此remove方法将会抛出异常。
 *
 * <p>
 * 需要注意的是，在构造此对象时需要保证原子性（原对象不被修改），最好加锁构造此对象，构造完毕后解锁。
 *
 * @ClassName: CopiedIterator
 * @Author: hireny
 * @Date: Created in 2020-01-11 7:46
 * @Version: 1.0
 */
public class CopiedIterator<E> implements Iterator<E>, Iterable<E>, Serializable {
    private static final long serialVersionUID = -2583498257753538119L;

    private Iterator<E> listIterator;

    public static <V> CopiedIterator<V> copyOf(Iterator<V> iterator) {
        return new CopiedIterator<>(iterator);
    }

    /**
     * 构造
     * @param iterator  被复制的Iterator
     */
    public CopiedIterator(Iterator<E> iterator) {
        final List<E> elements = Lists.newArrayList(iterator);
        this.listIterator = elements.iterator();
    }

    @Override
    public Iterator<E> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return this.listIterator.hasNext();
    }

    @Override
    public E next() {
        return this.listIterator.next();
    }

    /**
     * 此对象不支持移除元素
     * @throws UnsupportedOperationException    但调用此方法时始终抛出此异常
     */
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("THis is a read-only iterator.");
    }
}
