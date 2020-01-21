package org.hotilsframework.algos.container;

/**
 * @ClassName: LinkedStackTest
 * @Author: hireny
 * @Date: Create in 2019/12/20 16:27
 * @Description: TODO   链表实现的栈的测试
 */
public class LinkedStackTest {
    public static void main(String[] args) throws Exception {
        Stack<String> stack = new LinkedStack<>();
        stack.push("123456");
        stack.push("abcddfg");
        stack.push("我是小红花");
        stack.push("Java");
        stack.push("Python");
        stack.push("JavaScript");
        stack.push("C++");

        System.out.println("栈中的元素");
        for (String s : stack) {
            System.out.print(s + ", ");
        }
        System.out.println();

        System.out.println("判断栈是否为空");
        System.out.println(stack.isEmpty());

        System.out.println("获取栈的大小");
        System.out.println(stack.size());

        System.out.println("入栈之后的元素:");
        stack.push("入栈");
        for (String s : stack) {
            System.out.print(s + ", ");
        }
        System.out.println();

        System.out.println("数栈之后的元素：");
        stack.pop();
        for (String s : stack) {
            System.out.print(s + ", ");
        }
        System.out.println();

    }
}
