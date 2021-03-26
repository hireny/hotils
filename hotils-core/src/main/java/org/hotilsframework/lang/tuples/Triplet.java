package org.hotilsframework.lang.tuples;

import java.util.Objects;

/**
 * @author hireny
 * @className Triplet
 * @create 2020-04-10 10:14
 */
public class Triplet<A, B, C> extends AbstractTuple implements Tuple {
    private static final long serialVersionUID = 4492111459872997438L;
    private static final int SIZE = 3;

    private final A left;
    private final B middle;
    private final C right;

    public Triplet(A left, B middle, C right) {
        super(left, middle, right);
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public A getLeft() {
        return left;
    }

    public B getMiddle() {
        return middle;
    }

    public C getRight() {
        return right;
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
        if (!super.equals(o)) {
            return false;
        }
        Triplet<?, ?, ?> triplet = (Triplet<?, ?, ?>) o;
        return Objects.equals(left, triplet.left) &&
                Objects.equals(middle, triplet.middle) &&
                Objects.equals(right, triplet.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), left, middle, right);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                left +
                ", " + middle +
                ", " + right +
                '}';
    }
}
