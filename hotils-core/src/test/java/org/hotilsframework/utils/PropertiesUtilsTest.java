package org.hotilsframework.utils;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 配置文件工具类
 * @author hireny
 * @className PropertiesUtilsTest
 * @create 2020-02-21 12:26
 */
public class PropertiesUtilsTest {

    @Test
    public void propertiesTest() throws IOException {
        Properties properties = new Properties();
        InputStream in = this.getClass().getResourceAsStream("/propertiesTest.properties");
        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        properties.load(reader);
        System.out.println(properties.getProperty("test1"));
        System.out.println(properties.getProperty("test2"));
        System.out.println(properties.get("test3"));
        System.out.println(properties.getProperty("test4"));
        System.out.println(properties.getProperty("test5"));
    }
}
