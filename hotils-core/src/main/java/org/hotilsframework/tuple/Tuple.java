package org.hotilsframework.tuple;

import java.io.Serializable;
import java.util.*;

/**
 * @ClassName: Tuple
 * @Description: TODO   元组(不可变数组)
 * @Author: hireny
 * @Date: Created in 2020-01-10 1:58
 * @Version: 1.0
 */
public class Tuple implements Iterable<Object>,Comparable<Tuple>, Serializable {
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
    public Tuple(Object... args) {
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
        if (index >= getSize()) {
            throw new IllegalArgumentException(
                    "Cannot retrieve position " + index + " in " + this.getClass().getSimpleName() +
                    ". Positions for this class start with 0 and end with " + (getSize() - 1));
        }
        return (T) args[index];
    }

    public final boolean contains(final Object value) {
        for (final Object val : this.args) {
            if (val == null) {
                if (value == null) {
                    return true;
                }
            } else {
                if (val.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean contains(final Collection<?> collection) {
        for (final Object value : collection) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

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
     * @param value
     * @return
     */
    public final int indexOf(final Object value) {
        int i = 0;
        for (final Object val : this.args) {
            if (val == null && value == null) {
                return i;
            } else if (val.equals(value)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 获取所有元素
     * @return  获取所有元素
     */
    public Object[] getAll() {
        return this.args;
    }

    public int getSize() {
        return this.size;
    }

    public final List<Object> toList() {
        return Collections.unmodifiableList(new ArrayList<>(Arrays.asList(this.args)));
    }

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

//    @Override
//    public void forEach(Consumer<? super Object> action) {
//        if (action == null) {
//            return;
//        }
//        for (int i = 0, len = this.size; i < len; i++) {
//            action.accept();
//        }
//    }
//
//    @Override
//    public Spliterator<Object> spliterator() {
//        return null;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple objects = (Tuple) o;

        if (size != objects.size) return false;
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
    public int compareTo(Tuple o) {
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

        return (Integer.valueOf(this.size)).compareTo(Integer.valueOf(thatLength));
    }
}
