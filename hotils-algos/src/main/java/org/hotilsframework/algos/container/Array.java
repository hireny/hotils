package org.hotilsframework.algos.container;

/**
 * 数组类的实现
 * @author hireny
 * @className Array
 * @create 2020-02-19 14:03
 */
public class Array<T> {

    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 数组元素
     */
    private T[] data;
    /**
     * 数组大小
     */
    private int size;

    private int capacity;

    /**
     * 构造函数，传入的是存储在数组中的元素
     * @param values
     */
    public Array(T... values) {
        this(Math.max(DEFAULT_CAPACITY, values.length));
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造
     */
    public Array() {
        this(16);
    }

    /**
     * 数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组元素是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
