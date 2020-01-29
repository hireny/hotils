package org.hotilsframework.lang.primitives;

import org.hotilsframework.utils.Assert;

import java.util.Comparator;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/13 20:17
 */
public final class Booleans {

    private Booleans() {}

    /**
     * Comparators for {@code Boolean} values.
     * 布尔值比较器
     */
    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");

        private final int trueValue;
        private final String toString;

        BooleanComparator(int trueValue, String toString) {
            this.trueValue = trueValue;
            this.toString = toString;
        }

        @Override
        public int compare(Boolean o1, Boolean o2) {
            int aVal = o1 ? trueValue : 0;
            int bVal = o2 ? trueValue : 0;
            return bVal - aVal;
        }


        @Override
        public String toString() {
            return toString;
        }
    }

    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean value) {
        return value ? 1231 : 1237;
    }

    /**
     * 比较器，比较两个boolean值是大小，相等则返回0，不相等则返回a(为true返回1，为false返回-1)
     * @param a
     * @param b
     * @return
     */
    public static int compare(boolean a, boolean b) {
        return (a == b) ? 0 : (a ? 1 : -1);
    }

    /**
     * 判断boolean数组中书否存在目标
     * @param array
     * @param target
     * @return
     */
    public static boolean contains(boolean[] array, boolean target) {
        for (boolean value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first appearance of the value {@code target} in {@code array}.
     *
     * <p><b>Note:</b> consider representing the array as a {@link java.util.BitSet} instead, and
     * using {@link java.util.BitSet#nextSetBit(int)} or {@link java.util.BitSet#nextClearBit(int)}.
     *
     * @param array an array of {@code boolean} values, possibly empty
     * @param target a primitive {@code boolean} value
     * @return the least index {@code i} for which {@code array[i] == target}, or {@code -1} if no
     *     such index exists.
     */
    public static int indexOf(boolean[] array, boolean target) {
        return indexOf(array, target, 0, array.length);
    }

    // TODO(kevinb): consider making this public
    private static int indexOf(boolean[] array, boolean target, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the start position of the first occurrence of the specified {@code target} within
     * {@code array}, or {@code -1} if there is no such occurrence.
     *
     * <p>More formally, returns the lowest index {@code i} such that {@code ArrayUtils.copyOfRange(array,
     * i, i + target.length)} contains exactly the same elements as {@code target}.
     *
     * @param array the array to search for the sequence {@code target}
     * @param target the array to search for as a sub-sequence of {@code array}
     */
    public static int indexOf(boolean[] array, boolean[] target) {
        Assert.checkNotNull(array, "array");
        Assert.checkNotNull(target, "target");
        if (target.length == 0) {
            return 0;
        }

        outer:
        for (int i = 0; i < array.length - target.length + 1; i++) {
            for (int j = 0; j < target.length; j++) {
                if (array[i + j] != target[j]) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last appearance of the value {@code target} in {@code array}.
     *
     * @param array an array of {@code boolean} values, possibly empty
     * @param target a primitive {@code boolean} value
     * @return the greatest index {@code i} for which {@code array[i] == target}, or {@code -1} if no
     *     such index exists.
     */
    public static int lastIndexOf(boolean[] array, boolean target) {
        return lastIndexOf(array, target, 0, array.length);
    }

    // TODO(kevinb): consider making this public
    private static int lastIndexOf(boolean[] array, boolean target, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the values from each provided array combined into a single array. For example, {@code
     * concat(new boolean[] {a, b}, new boolean[] {}, new boolean[] {c}} returns the array {@code {a,
     * b, c}}.
     *
     * @param arrays zero or more {@code boolean} arrays
     * @return a single array containing all the values from the source arrays, in order
     */
    public static boolean[] concat(boolean[]... arrays) {
        int length = 0;
        for (boolean[] array : arrays) {
            length += array.length;
        }
        boolean[] result = new boolean[length];
        int pos = 0;
        for (boolean[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }
}
