package org.hotilsframework.lang.tuples;

import java.util.Objects;

/**
 *
 * 一元组
 *
 * @author hireny
 * @className Unit
 * @create 2020-04-10 10:14
 */
public class Unit<E> extends AbstractTuple implements Tuple {
    private static final long serialVersionUID = -4287309813869102196L;
    private static final int SIZE = 1;
    private final E first;

    public Unit(E value) {
        super(value);
        this.first = value;
    }

    public E getFirst() {
        return this.first;
    }

    @Override
    public int size() {
        return SIZE;
    }

    public E getValue() {
        return first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Unit<?> unit = (Unit<?>) o;

        return Objects.equals(first, unit.first);
    }



    @Override
    public int hashCode() {
        return first != null ? first.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                first +
                '}';
    }
}
