package me.hireny.commons.container;

/**
 * @ClassName: Stack
 * @Author: hireny
 * @Date: Create in 2019/12/20 15:52
 * @Description: TODO   栈的接口操作
 *
 * 栈的数据结构：先进后出
 */
public interface Stack<E> extends Iterable<E> {

    /**
     * 入栈
     * @param e
     * @return
     */
    Stack<E> push(E e);

    /**
     * 出栈
     * @return
     * @throws Exception
     */
    E pop() throws Exception;

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取栈的大小
     * @return
     */
    int size();
}
