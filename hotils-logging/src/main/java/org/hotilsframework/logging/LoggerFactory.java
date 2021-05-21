package org.hotilsframework.logging;

/**
 * 日志工厂接口，所有的日志对象都根据这个接口标准
 * @ClassName: LoggerManager
 * @Author: hireny
 * @Date: Created in 2020-02-03 16:17
 * @Version: 1.0
 */
public class LoggerFactory {

    private static Loggers loggers;

    static {
        loggers = new Loggers();
    }

    public static Loggers getLoggers() {
        return loggers;
    }

    /**
     * 获取日志记录器
     * @param clazz
     * @return
     */
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    /**
     * 获取日志记录器
     * @param name
     * @return
     */
    public static Logger getLogger(String name) {
        return getLoggers().getLogger(name);
    }
}
