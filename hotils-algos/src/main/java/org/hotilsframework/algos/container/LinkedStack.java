package org.hotilsframework.algos.container;

import java.util.Iterator;

/**
 * @ClassName: LinkedStack
 * @Author: hireny
 * @Date: Create in 2019/12/20 16:01
 * @Description: TODO   链表实现栈
 */
public class LinkedStack<E> implements Stack<E> {

    private Node top = null;
    private int n = 0;

    @Override
    public Stack<E> push(E e) {

        Node newTop = new Node();
        newTop.item = e;
        newTop.next = top;

        top = newTop;

        n++;

        return this;
    }

    @Override
    public E pop() throws Exception {
        if (isEmpty()) {
            // 栈是空的异常
            throw new Exception("stack is empty");
        }

        E item = top.item;
        top = top.next;
        n--;
        return item;
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
        return new Iterator<E>() {

            private Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    /**
     * 节点元素类
     */
    private class Node {
        E item;
        Node next;
    }
}
