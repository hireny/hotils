package org.hotilsframework.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: PropertiesUtils
 * @Author: hireny
 * @Date: Create in 2019/12/07 22:53
 * @Description: TODO   提供一些常用的属性文件相关的方法.
 */
public final class PropertiesUtils {
    private PropertiesUtils() {}

    /**
     * 获取properties
     * @param path
     * @return
     */
    public static Properties getProperties(String path) {
        Assert.notNull(path, "Properties path not null.");
        Properties properties = new Properties();
        try (InputStream in = new BufferedInputStream(new FileInputStream(path))) {
            properties.load(in);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("path error.");
        }
    }

    /**
     * 从系统属性文件中获取相应的值.
     *
     * @param key key
     * @return 返回value
     */
    public static String key(String key) {
        return System.getProperty(key);
    }


    public static Boolean getBoolean(Properties properties, String key, Boolean defaultValue) {
        return NumberUtils.toBoolean(properties.getProperty(key), defaultValue);
    }

    public static Short getShort(Properties properties, String key, Short defaultValue) {
        return NumberUtils.toShort(properties.getProperty(key), defaultValue);
    }

    public static Integer getInt(Properties properties, String key, Integer defaultValue) {
        return NumberUtils.toInt(properties.getProperty(key), defaultValue);
    }

    public static Long getLong(Properties properties, String key, Long defaultValue) {
        return NumberUtils.toLong(properties.getProperty(key), defaultValue);
    }

    public static Float getFloat(Properties properties, String key, Float defaultValue) {
        return NumberUtils.toFloat(properties.getProperty(key), defaultValue);
    }

    public static Double getDouble(Properties properties, String key, Double defaultValue) {
        return NumberUtils.toDouble(properties.getProperty(key), defaultValue);
    }


    /**
     * 根据Key读取Value.
     *
     * @param filePath 属性文件
     * @param key      需要读取的属性
     */
    public static String getPropertyValue(String filePath, String key) {
        Properties pps = new Properties();
        try (InputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
            pps.load(in);
            return pps.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据key读取value
     * @param properties    配置工具类
     * @param key           需要读取的属性
     * @return
     */
    public static String getPropertyValue(Properties properties, String key) {
        return properties.getProperty(key);
    }

    /**
     * 根据key读取value，如果没有则返回默认值
     * @param properties    配置工具
     * @param key           需要读取的属性
     * @param defaultValue  默认值
     * @return
     */
    public static String getPropertyValue(Properties properties, String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * 读取Properties的全部信息.
     *
     * @param filePath 读取的属性文件
     * @return 返回所有的属性 key:value<>key:value
     */
    public static Map<String, String> loadProperties(String filePath) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            return loadProperties(bf);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private static Map<String, String> loadProperties(Reader in) throws IOException {
        Map<String, String> map = new HashMap<>(5);
        Properties pps = new Properties();
        try {
            pps.load(in);
        } catch (IOException e) {
            throw new IOException(e);
        }
        Enumeration en = pps.propertyNames();
        while (en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            map.put(strKey, strValue);
        }
        return map;
    }

}
