package me.hireny.commons.core.system;

import me.hireny.commons.core.lang.Strings;

import java.io.Console;
import java.lang.management.ManagementFactory;
import java.util.Properties;

/**
 * @ClassName: Systems
 * @Author: hireny
 * @Date: Create in 2019/12/08 15:14
 * @Description: TODO   System工具类
 */
public class Systems {
    private Systems() {}

    /**
     * 获取系统属性，如果因为Java安全的限制而失败，则将错误打在Log中，然后返回defaultValue
     * @param name              属性名
     * @param defaultValue      默认值
     * @return  属性值或默认值
     */
    public static String get(String name, String defaultValue) {
        return Strings.isBlank(get(name, false)) ? defaultValue : get(name, false);
    }

    /**
     * 获取系统属性，如果因为Java安全的限制而失败，则返回null
     * @param name      属性名
     * @param quiet     打印模式，不讲错误信息打印在 {@code System.error}
     * @return  属性值或 {@code null}
     */
    public static String get(String name, boolean quiet) {
        String value = null;
        try {
            value = System.getProperty(name);
        } catch (SecurityException e) {
//            if (false == quiet) {
//                Console.error
//            }
        }
        if (null == value) {
            try {
                value = System.getenv(name);
            } catch (SecurityException e) {
//                if (false == quiet) {
//
//                }
            }
        }
        return value;
    }


    /**
     * 获得System属性
     *
     * @param key 键
     * @return 属性值
     * @see System#getProperty(String)
     * @see System#getenv(String)
     */
    public static String get(String key) {
        return get(key, null);
    }

    /**
     * 获得boolean类型值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
//    public static boolean getBoolean(String key, boolean defaultValue) {
//        String value = get(key);
//        if (value == null) {
//            return defaultValue;
//        }
//
//        value = value.trim().toLowerCase();
//        if (value.isEmpty()) {
//            return true;
//        }
//
//        return Convert.toBool(value, defaultValue);
//    }

    /**
     * 获得int类型值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
//    public static long getInt(String key, int defaultValue) {
//        return Convert.toInt(get(key), defaultValue);
//    }

    /**
     * 获得long类型值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
//    public static long getLong(String key, long defaultValue) {
//        return Convert.toLong(get(key), defaultValue);
//    }

    /**
     * @return 属性列表
     */
    public static Properties props() {
        return System.getProperties();
    }

    /**
     * 获取当前进程 PID
     *
     * @return 当前进程 ID
     */
    public static long getCurrentPID() {
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        int indexOf = pid.indexOf('@');
        if (indexOf > 0) {
            pid = pid.substring(0, indexOf);
        }
        return Long.parseLong(pid);
    }
}
