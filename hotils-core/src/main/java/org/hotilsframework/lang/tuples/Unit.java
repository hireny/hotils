package org.hotilsframework.lang.tuples;

/**
 * @ClassName: Unit
 * @Author: hireny
 * @Date: Created in 2020-01-15 14:12
 * @Version: 1.0
 */
public class Unit<T> extends Tuple {
    private static final long serialVersionUID = -4287309813869102196L;
    private static final int SIZE = 1;
    private T first;

    public Unit(T value) {
        this.first = value;
    }

    public T getFirst() {
        return this.first;
    }

    @Override
    public int size() {
        return SIZE;
    }

    public T getValue() {
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

        return first != null ? first.equals(unit.first) : unit.first == null;
    }

    @Override
    public int hashCode() {
        return first != null ? first.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "value=" + first +
                '}';
    }
}
