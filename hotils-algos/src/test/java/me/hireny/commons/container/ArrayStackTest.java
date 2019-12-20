package me.hireny.commons.container;

/**
 * @ClassName: ArrayStackTest
 * @Author: hireny
 * @Date: Create in 2019/12/20 16:21
 * @Description: TODO   数组实现栈的测试
 */
public class ArrayStackTest {

    public static void main(String[] args) throws Exception {
        Stack<String> stack = new ArrayStack<>();
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
