package org.hotilsframework.io;

import org.junit.Test;

/**
 * 标准输出测试类
 * @ClassName: StdOutTest
 * @Author: hireny
 * @Date: Created in 2020-02-08 18:36
 * @Version: 1.0
 */
public class StdOutTest {

    @Test
    public void stdOutTest() {
        // write to stdout
        System.out.println("Test");
        StdOut.println(17);
        StdOut.println(true);
        StdOut.printf("%.6f\n", 1.0/7.0);
    }
}
