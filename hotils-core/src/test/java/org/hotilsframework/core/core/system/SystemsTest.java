package org.hotilsframework.core.core.system;

import org.hotilsframework.core.system.Systems;
import org.junit.Test;

/**
 * @ClassName: SystemsTest
 * @Description: TODO   系统工具类测试
 * @Author: hireny
 * @Date: Created in 2020-01-08 7:35
 * @Version: 1.0
 */
public class SystemsTest {

    @Test
    public void currentPidTest() {
        Long pid = Systems.getCurrentPID();
        System.out.println("当前线程PID="+pid);
    }
}
