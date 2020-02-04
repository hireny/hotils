package org.hotilsframework.utils;

import org.hotilsframework.utils.IdentityCardUtils;
import org.junit.Test;

/**
 * @ClassName: IdentityCardUtilsTest
 * @Description: TODO   身份证号工具测试类
 * @Author: hireny
 * @Date: Created in 2020-01-09 15:26
 * @Version: 1.0
 */
public class IdentityCardUtilsTest {

    @Test
    public void identityCardTest() throws Throwable {
        System.out.println(IdentityCardUtils.getGenderFromPersonIDCode("11010519491231002X"));
        System.out.println(IdentityCardUtils.isIdentity("530626199109261396"));
    }
}
