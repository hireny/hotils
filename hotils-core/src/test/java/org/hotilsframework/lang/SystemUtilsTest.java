package org.hotilsframework.lang;

import org.hotilsframework.lang.SystemUtils;
import org.junit.Test;

/**
 * 系统工具测试类
 * @author hireny
 * @className SystemUtilsTest
 * @create 2020-02-18 23:17
 */
public class SystemUtilsTest {

    /**
     * 获取当前进程信息
     */
    @Test
    public void processTest() {
        System.out.print("获取当前进程ID：");
        System.out.println(SystemUtils.getCurrentPID());
    }
}
