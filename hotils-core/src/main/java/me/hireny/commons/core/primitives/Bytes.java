package me.hireny.commons.core.primitives;

import me.hireny.commons.utils.ArrayUtils;
import me.hireny.commons.utils.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/04 10:19
 */
public class Bytes {
    private Bytes() {}

    /**
     * 获取byte基本类型的hashCode
     * @param value
     * @return
     */
    public static int hashCode(byte value) {
        return value;
    }

    /**
     * 判断数组中是否存在该值
     * @param array
     * @param target
     * @return
     */
    public static boolean contains(byte[] array, byte target) {
        for (byte value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取target值在byte数组中的下标
     * @param array
     * @param target
     * @return
     */
    public static int indexOf(byte[] array, byte target) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }
        return indexOf(array, target, 0, array.length);
    }

    /**
     * 获取target值在byte数组中的下标
     * @param array
     * @param target
     * @param start
     * @param end
     * @return
     */
    private static int indexOf(byte[] array, byte target, int start, int end) {
        for (int i=start; i < end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取target数组在byte数组中的下标
     * @param array
     * @param target
     * @return
     */
    public static int indexOf(byte[] array, byte[] target) {
        Assert.checkNotNull(array, "array");
        Assert.checkNotNull(target, "target");
        if (target.length == 0) {
            return 0;
        }

        outer:
        for (int i=0; i < array.length - target.length + 1; i++) {
            for (int j=0; j < target.length; j++) {
                if (array[i+j]!=target[j]) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    /**
     * 从后遍历，获取target目标的下标值，不存在则返回-1
     * @param array
     * @param target
     * @return
     */
    public static int lastIndexOf(byte[] array, byte target) {
        return lastIndexOf(array, target, 0, array.length);
    }

    /**
     * 从后遍历，获取target目标的下标值，不存在则返回-1
     * @param array
     * @param target
     * @param start
     * @param end
     * @return
     */
    public static int lastIndexOf(byte[] array, byte target, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 将各个数组拼接为一个数组
     * @param arrays
     * @return
     */
    public static byte[] concat(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }

        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }

    /**
     * 从集合中获取byte数组
     * @return
     */
    public static byte[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ByteArrayAsList) {
            // 从集合中获取byte数组
            return ((ByteArrayAsList) collection).toByteArray();
        }

        Object[] boxedArray = collection.toArray();
        int length = boxedArray.length;
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = ((Number) Assert.checkNotNull(boxedArray[i])).byteValue();
        }
        return array;
    }

    public static List<Byte> asList(byte... backingArray) {
        if (backingArray.length == 0) {
            return Collections.emptyList();
        }
        return new ByteArrayAsList(backingArray);
    }

    public byte[] getBytes() {
        return null;
    }

    /**
     *  将byte数组包装到集合中
     */
    private static class ByteArrayAsList extends AbstractList<Byte>
            implements RandomAccess, Serializable {

        final byte[] array;
        final int start;
        final int end;

        ByteArrayAsList(byte[] array) {
            this(array, 0, array.length);
        }

        ByteArrayAsList(byte[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Byte get(int index) {
            Assert.checkElementIndex(index, size());
            return array[start + index];
        }

        @Override
        public int size() {
            return end - start;
        }

        @Override
        public boolean contains(Object target) {
            // Overridden to prevent a ton of boxing
            return (target instanceof Byte) && Bytes.indexOf(array, (Byte) target, start, end) != -1;
        }

        @Override
        public int indexOf(Object target) {
            // Overridden to prevent a ton of boxing
            if (target instanceof Byte) {
                int i = Bytes.indexOf(array, (Byte) target, start, end);
                if (i >= 0) {
                    return i - start;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object target) {
            // Overridden to prevent a ton of boxing
            if (target instanceof Byte) {
                int i = Bytes.lastIndexOf(array, (Byte) target, start, end);
                if (i >= 0) {
                    return i - start;
                }
            }
            return -1;
        }

        /**
         * 设置索引的值
         * @param index
         * @param element
         * @return
         */
        @Override
        public Byte set(int index, Byte element) {
            Assert.checkElementIndex(index, size());
            byte oldValue = array[start + index];
            // checkNotNull for GWT (do not optimize)
            array[start + index] = Assert.checkNotNull(element);
            return oldValue;
        }

        /**
         * 从集合中获取子集合
         * @param fromIndex
         * @param toIndex
         * @return
         */
        @Override
        public List<Byte> subList(int fromIndex, int toIndex) {
            int size = size();
            Assert.checkPositionIndexes(fromIndex, toIndex, size);
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            return new ByteArrayAsList(array, start + fromIndex, start + toIndex);
        }

        /**
         * 是否相同
         * @param object
         * @return
         */
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof ByteArrayAsList) {
                ByteArrayAsList that = (ByteArrayAsList) object;
                int size = size();
                if (that.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (array[start + i] != that.array[that.start + i]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(object);
        }

        /**
         * 重写hashCode
         * @return
         */
        @Override
        public int hashCode() {
            int result = 1;
            for (int i = start; i < end; i++) {
                result = 31 * result + Bytes.hashCode(array[i]);
            }
            return result;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(size() * 5);
            builder.append('[').append(array[start]);
            for (int i = start + 1; i < end; i++) {
                builder.append(", ").append(array[i]);
            }
            return builder.append(']').toString();
        }

        byte[] toByteArray() {
            return Arrays.copyOfRange(array, start, end);
        }

        private static final long serialVersionUID = 0;
    }

    /**
     * 反转byte数组
     * @param array
     */
    public static void reverse(byte[] array) {
        Assert.checkNotNull(array);
        reverse(array, 0, array.length);
    }

    /**
     * 反转byte数组
     * @param array
     * @param fromIndex
     * @param toIndex
     */
    public static void reverse(byte[] array, int fromIndex, int toIndex) {
        Assert.checkNotNull(array);
        Assert.checkPositionIndexes(fromIndex, toIndex, array.length);
        for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
            byte tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
