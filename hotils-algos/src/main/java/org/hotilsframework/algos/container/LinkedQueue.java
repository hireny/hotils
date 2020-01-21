package org.hotilsframework.algos.container;

import java.util.Iterator;

/**
 * @ClassName: LinkedQueue
 * @Author: hireny
 * @Date: Create in 2019/12/20 16:09
 * @Description: TODO   使用链表实现队列
 */
public class LinkedQueue<E> implements Queue<E> {

    /**
     * 起始节点
     */
    private Node first;
    /**
     * 末尾节点
     */
    private Node last;
    /**
     * 元素数量
     */
    int n = 0;

    @Override
    public Queue<E> add(E e) {

        Node newNode = new Node();
        newNode.item = e;
        newNode.next = null;

        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        n++;

        return this;
    }

    @Override
    public E remove() throws Exception {
        if (isEmpty()) {
            // 队列为空的异常
            throw new Exception("queue is empty");
        }
        Node node = first;
        first = first.next;
        n--;

        if (isEmpty()) {
            last = null;
        }
        return node.item;
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

            Node current = first;

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
        /**
         * 节点元素
         */
        E item;
        /**
         * 指向下一个节点
         */
        Node next;
    }
}
