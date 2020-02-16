package org.hotilsframework.core.logging;

import org.hotilsframework.core.collection.Maps;

import java.util.Map;

/**
 * 日志工厂接口，所有的日志对象都根据这个接口标准
 * @ClassName: LoggerManager
 * @Author: hireny
 * @Date: Created in 2020-02-03 16:17
 * @Version: 1.0
 */
public class LoggerFactory {

    /**
     * 日志记录器
     */
    private static Map<String, Logger> loggerMap;

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
        return null;
    }
}
