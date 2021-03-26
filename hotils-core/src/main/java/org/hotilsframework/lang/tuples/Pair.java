package org.hotilsframework.lang.tuples;

import java.util.Objects;

/**
 *
 * 二元组
 *
 * @author hireny
 * @className Pair
 * @create 2020-04-10 10:14
 */
public class Pair<A, B> extends AbstractTuple implements Tuple {
    private static final long serialVersionUID = 5246276620136848321L;
    private static final int SIZE = 2;
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        super(first, second);
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!Objects.equals(first, pair.first)) {
            return false;
        }
        return Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                first +
                ", " + second +
                '}';
    }
}
