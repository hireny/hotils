package org.hotilsframework.utils;

import org.junit.Test;

import java.util.Properties;

/**
 * 配置文件工具类
 * @author hireny
 * @className PropertiesUtilsTest
 * @create 2020-02-21 12:26
 */
public class PropertiesUtilsTest {

    @Test
    public void propertiesTest() {
        Properties properties = PropertiesUtils.getProperties("propertiesTest.properties");
        System.out.println(properties);
        System.out.println(PropertiesUtils.getBoolean(properties, "test1", false));
    }
}
