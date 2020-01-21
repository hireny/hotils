package org.hotilsframework.core.core.pools;

import org.hotilsframework.core.pools.DefaultObjectPools;
import org.hotilsframework.core.pools.ObjectFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: DefaultObjectPoolsTest
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:46
 * @Description: TODO   默认对象池的测试
 */
public class DefaultObjectPoolsTest {
    private DefaultObjectPools<String> pools = null;

    public DefaultObjectPoolsTest() {
        ObjectFactory<String> factory = () -> "add";
        pools = new DefaultObjectPools<>(factory, 5);
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
