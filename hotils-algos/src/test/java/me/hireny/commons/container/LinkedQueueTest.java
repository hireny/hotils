package me.hireny.commons.container;

/**
 * @ClassName: LinkedQueueTest
 * @Author: hireny
 * @Date: Create in 2019/12/20 16:28
 * @Description: TODO   链表实现的队列的测试
 */
public class LinkedQueueTest {
    public static void main(String[] args) throws Exception {
        Queue<String> queue = new LinkedQueue<>();
        queue.add("123456");
        queue.add("abcddfg");
        queue.add("我是小红花");
        queue.add("Java");
        queue.add("Python");
        queue.add("JavaScript");
        queue.add("C++");

        System.out.println("队列中的元素");
        for (String s : queue) {
            System.out.print(s + ", ");
        }
        System.out.println();

        System.out.println("判断队列是否为空");
        System.out.println(queue.isEmpty());

        System.out.println("获取队列的大小");
        System.out.println(queue.size());

        System.out.println("入队列之后的元素:");
        queue.add("入队列");
        for (String s : queue) {
            System.out.print(s + ", ");
        }
        System.out.println();

        System.out.println("出队列之后的元素：");
        queue.remove();
        for (String s : queue) {
            System.out.print(s + ", ");
        }
        System.out.println();

    }
}
