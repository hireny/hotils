package me.hireny.commons.core.tuple;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @ClassName: Tuple
 * @Description: TODO   元组(不可变数组)
 * @Author: hireny
 * @Date: Created in 2020-01-10 1:58
 * @Version: 1.0
 */
public class Tuple implements Iterable<Object>, Serializable {
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
        return (T) args[index];
    }

    /**
     * 获取所有元素
     * @return  获取所有元素
     */
    public Object[] getAll() {
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
    public String toString() {
        return Arrays.toString(args);
    }
}
