package org.hotilsframework.lang;

import java.lang.management.ManagementFactory;
import java.util.Properties;

/**
 * 系统信息工具类
 * @author hireny
 * @className OsUtils
 * @create 2020-02-18 23:12
 */
public final class SystemUtils {

    //******************Java运行时环境信息**********************//
    /**
     * Java版本号，Java运行时环境版本
     */
    public static final String VERSION = "java.version";
    /**
     * Java提供商名称,Java运行时环境供应商
     */
    public static final String VENDOR = "java.vendor";
    /**
     * Java提供商网站,Java供应商的URL
     */
    public static final String VENDOR_URL = "java.vendor.url";
    /**
     * Java，哦，应该是jre目录,Java安装目录
     */
    public static final String HOME = "java.home";

    /**
     * Java规范版本号，Java运行时环境规范版本
     */
    public static final String SPECIFICATION_VERSION = "java.specification.version";
    /**
     * Java规范提供商，Java运行时环境规范供应商
     */
    public static final String SPECIFICATION_VENDOR = "java.specification.vendor";
    /**
     * Java规范名称,Java运行时环境规范名称
     */
    public static final String SPECIFICATION_NAME = "java.specification.name";
    /**
     * Java lib路径，加载库时搜索的路径列表
     */
    public static final String LIBRARY_PATH = "java.library.path";
    /**
     * Java输入输出临时路径，默认的临时文件路径
     */
    public static final String TMPDIR = "java.io.tmpdir";
    /**
     * Java编译器，要使用 JIT编译器的名称
     */
    public static final String COMPILER = "java.compiler";
    /**
     * Java执行路径,一个或多个扩展目录的路径
     */
    public static final String EXT_DIRS = "java.ext.dirs";

    //******************Java运行时环境信息**********************//


    //******************Java虚拟机信息**********************//
    /**
     * Java虚拟机版本号
     */
    public static final String JVM_VERSION = "java.vm.version";
    /**
     * Java虚拟机提供商
     */
    public static final String JVM_VENDOR = "java.vm.vendor";
    /**
     * Java虚拟机名称
     */
    public static final String JVM_NAME = "java.vm.name";
    /**
     * Java虚拟机信息
     */
    public static final String JVM_INFO = "java.vm.info";
    /**
     * Java虚拟机规范版本号
     */
    public static final String JVM_SPECIFICATION_VERSION = "java.vm.specification.version";
    /**
     * Java虚拟机规范提供商
     */
    public static final String JVM_SPECIFICATION_VENDOR= "java.vm.specification.vendor";
    /**
     * Java虚拟机规范名称
     */
    public static final String JVM_SPECIFICATION_NAME = "java.vm.specification.name";


    //******************Java虚拟机信息**********************//


    //******************Java类信息**********************//
    /**
     * Java类版本号
     */
    public static final String JAVA_CLASS_VERSION = "java.class.version";
    /**
     * Java类路径
     */
    public static final String JAVA_CLASS_PATH = "java.class.path";
    //******************Java类信息**********************//


    //******************OS信息**********************//
    /**
     * 操作系统名称
     */
    public static final String OS_NAME = "os.name";
    /**
     * 操作系统的架构
     */
    public static final String OS_ARCH = "os.arch";
    /**
     * 操作系统版本号
     */
    public static final String OS_VERSION = "os.version";
    /**
     * 文件分隔符
     */
    public static final String FILE_SPEARATOR = "file.separator";
    /**
     * 路径分隔符
     */
    public static final String PATH_SEPARATOR = "path.separator";
    /**
     * 直线分隔符
     */
    public static final String LINE_SEPARATOR = "line.separator";
    //******************OS信息**********************//







    //******************用户信息**********************//
    /**
     * 用户名
     */
    String USER_NAME = "user.name";
    /**
     * 用户的主目录
     */
    String USER_HOME = "user.home";
    /**
     * 当前程序所在目录
     */
    String USER_DIR = "user.dir";
    //******************用户信息**********************//

    

    private SystemUtils() {
        throw new AssertionError();
    }

    /**
     * 获取系统属性，如果因为Java安全的限制而失败，则将错误打在Log中，然后返回defaultValue
     * @param name              属性名
     * @param defaultValue      默认值
     * @return  属性值或默认值
     */
    public static String get(String name, String defaultValue) {
        return StringUtils.isBlank(get(name, false)) ? defaultValue : get(name, false);
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
    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }

        value = value.trim().toLowerCase();
        switch (value) {
            case "true" :
            case "yes"  :
            case "1"    :
            case "on"   :
                return true;
            case "false":
            case "no"   :
            case "0"    :
            case "off"  :
                return false;
            default:
                return defaultValue;
        }
    }

    /**
     * 获得int类型值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
    public static long getInt(String key, int defaultValue) {
        String value = get(key);
        if (null == value) {
            return defaultValue;
        }
        value = value.trim().toLowerCase();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    /**
     * 获得long类型值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
    public static long getLong(String key, long defaultValue) {
        String value = get(key);
        if (null == value) {
            return defaultValue;
        }
        value = value.trim().toLowerCase();
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    /**
     * @return 属性列表
     */
    public static Properties props() {
        return System.getProperties();
    }

    public static String getCurrentProcess() {
        return ManagementFactory.getRuntimeMXBean().getName();
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
