package me.hireny.commons.core.math;

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
        System.out.println(BigDecimals.add(1.000001, 2.10));
    }
}
