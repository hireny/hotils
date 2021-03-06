package org.hotilsframework.lang.tuples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Tuple
 * 元组(不可变数组)
 *
 * @author hireny
 * @date Created in 2020-01-10 1:58
 * @version 1.0
 */
public abstract class AbstractTuple implements Tuple, Comparable<AbstractTuple>, Serializable {
    private static final long serialVersionUID = -8274734076775895891L;
    /**
     * 成员
     */
    private Object[] args;
    /**
     * 大小
     */
    private int size;

    /**
     * 构造
     * @param args  成员数组
     */
    public AbstractTuple(Object... args) {
        this.args = args;
        this.size = args.length;
    }

    /**
     * 获取指定位置元素
     * @param index 位置
     * @param <T>   返回对象类型
     * @return      元素
     */
    @SuppressWarnings("unchecked")
    public <T> T get(int index) {
        if (index >= size()) {
            throw new IllegalArgumentException(
                    "Cannot retrieve position " + index + " in " + this.getClass().getSimpleName() +
                    ". Positions for this class start with 0 and end with " + (size() - 1));
        }
        return (T) args[index];
    }

    /**
     * 判断值是否存在元组中
     * @param value
     * @return
     */
    @Override
    public final boolean contains(final Object value) {
        for (final Object val : this.args) {
            if (val == null && value == null) {
                return true;
            } else {
                if (value.equals(val)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean contains(final Collection<?> collection) {
        for (final Object value : collection) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean contains(final Object... values) {
        if (values == null) {
            throw new IllegalArgumentException("Values array cannot be null");
        }
        for (final Object value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取元素位置
     * @param value     要索引的值
     * @return          返回元素位置
     */
    @Override
    public final int indexOf(final Object value) {
        int i = 0;
        for (final Object val : this.args) {
            if (val == null && value == null) {
                return i;
            } else if (value.equals(val)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 获取元素位置
     * @param value     要索引的值
     * @return          返回元素位置
     */
    @Override
    public final int lastIndexOf(final Object value) {
        for (int i = size()-1; i >= 0; i--) {
            final Object val = args[i];
            if (val == null && value == null) {
                return i;
            } else if (value.equals(val)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public final List<Object> toList() {
        return Collections.unmodifiableList(new ArrayList<>(Arrays.asList(this.args)));
    }

    @Override
    public final Object[] toArray() {
        return this.args;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {

            private int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex + 1 < size;
            }

            @Override
            public Object next() {
                currentIndex++;
                return args[currentIndex];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Object> action) {
        if (action == null) {
            return;
        }
        for (int i = 0, len = this.size; i < len; i++) {
            action.accept(args[i]);
        }
    }

//    @Override
//    public Spliterator<Object> spliterator() {
//        return null;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractTuple objects = (AbstractTuple) o;

        if (size != objects.size) {
            return false;
        }
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(args, objects.args);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(args);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(args);
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public int compareTo(AbstractTuple o) {
        final Object[] thatValues = o.args;
        final int thatLength = o.size;

        for (int i = 0; i < this.size && i < thatLength; i++) {
            final Comparable thisElement = (Comparable) this.args[i];
            final Comparable thatElement = (Comparable) thatValues[i];

            final int comparison = thisElement.compareTo(thatElement);
            if (comparison != 0) {
                return comparison;
            }
        }

        return Integer.compare(this.size, thatLength);
    }
}
