package org.hayros.commons.container;

/**
 * @ClassName: Queue
 * @Author: hireny
 * @Date: Create in 2019/12/20 16:08
 * @Description: TODO   队列的实现
 *
 * 队列的数据结构：先进先出
 */
public interface Queue<E> extends Iterable<E> {
    /**
     * 队列中添加元素
     * @param e
     * @return
     */
    Queue<E> add(E e);

    /**
     * 从队列中移除元素
     * @return              返回移除的的元素
     * @throws Exception
     */
    E remove() throws Exception;

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取队列的大小
     * @return
     */
    int size();
}
