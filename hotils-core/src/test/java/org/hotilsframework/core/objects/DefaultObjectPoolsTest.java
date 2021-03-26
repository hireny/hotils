package org.hotilsframework.core.objects;

import org.hotilsframework.core.factory.DefaultObjectProvider;
import org.hotilsframework.core.factory.ObjectProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: DefaultObjectPoolsTest
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:46
 * @Description: TODO   默认对象池的测试
 */
public class DefaultObjectPoolsTest {
    private DefaultObjectProvider pools = null;

    public DefaultObjectPoolsTest() {
        ObjectProvider factory = () -> "add";
        pools = new DefaultObjectProvider(factory, 5);
    }

    @Test
    public void getTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(pools.get());
            Assert.assertNotNull(pools.get());
        }
    }

    @Test
    public void releaseTest() {
        for (int i = 0; i < 10; i++) {
            pools.release("release");
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertNotNull(pools.get());
        }
    }
}
