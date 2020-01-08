package org.hayros.commons.container;

import java.util.Iterator;

/**
 * @ClassName: ArrayStack
 * @Author: hireny
 * @Date: Create in 2019/12/20 15:54
 * @Description: TODO   数组实现的栈
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 栈元素数组，只能通过转型来创建泛型数组
     */
    private E[] items = (E[]) new Object[16];
    /**
     * 元素数量
     */
    private int n = 0;

    @Override
    public Stack<E> push(E e) {
        check();
        items[n++] = e;
        return this;
    }

    @Override
    public E pop() throws Exception {
        if (isEmpty()) {
            // 栈是空的异常
            throw new Exception("stack is empty");
        }

        E item = items[--n];
        check();

        // 避免对象游离
        items[n] = null;

        return item;
    }

    /**
     * 栈的检查
     */
    private void check() {
        if (n >= items.length) {
            resize(2 * items.length);
        } else if (n > 0 && n <= items.length >> 2) { // items.length / 4
            // items.length / 2
            resize(items.length >> 1);
        }
    }

    /**
     * 调整数组大小，使得栈具有伸缩性
     * @param size
     */
    private void resize(int size) {
        E[] tmp = (E[]) new Object[size];

        for (int i = 0; i < n; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<E> iterator() {

        // 返回逆序遍历的迭代器
        return new Iterator<E>() {

            private int i = n;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public E next() {
                return items[--i];
            }
        };
    }
}
