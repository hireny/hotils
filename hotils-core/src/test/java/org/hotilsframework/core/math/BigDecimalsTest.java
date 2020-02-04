package org.hotilsframework.core.math;

import org.hotilsframework.utils.NumberUtils;
import org.junit.Test;

/**
 * @ClassName: BigDecimalsTest
 * @Description: TODO
 * @Author: hireny
 * @Date: Created in 2020-01-09 15:43
 * @Version: 1.0
 */
public class BigDecimalsTest {

    @Test
    public void bigDecimalsAddTest() {
        System.out.println(NumberUtils.add(1.000001, 2.10));
    }
}
