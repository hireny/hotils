package org.hotilsframework.core.logger;

/**
 * 日志接口
 * @ClassName: Logger
 * @Author: hireny
 * @Date: Created in 2020-02-03 16:16
 * @Version: 1.0
 */
public interface Logger {

    /**
     * info: 传入一个Object对象
     * @param o
     */
    void info(Object o);

    /**
     * info: 字符串格式化输出
     *
     * @param message   String格式化字符串
     * @param args      参数
     */
    void info(String message, Object... args);

    /**
     * info：字符串格式化输出
     * @param message   String格式化字符串
     * @param t         线程
     * @param args      参数
     */
    void info(String message, Thread t, Object... args);

    /**
     * info: 格式化输出
     * @param tag       标签
     * @param o         对象
     */
    void info(String tag, Object o);

    /**
     * info：传入一个String信息
     * @param tag       标签
     * @param message   String格式化字符串
     * @param args      参数
     */
    void info(String tag, String message, Object... args);

    /**
     * 传入格式化String字符串和线程以及格式化参数
     * @param tag       标签
     * @param message   格式化字符串
     * @param t         线程
     * @param args      参数
     */
    void info(String tag,String message, Thread t, Object... args);

    /**
     * debug: 传入一个Object对象
     * @param o
     */
    void debug(Object o);

    void debug(String message, Object... args);

    void debug(String message, Thread t, Object... args);

    /**
     * debug
     * @param tag   标签
     * @param o     对象
     */
    void debug(String tag, Object o);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param args      参数
     */
    void debug(String tag, String message, Object... args);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param t         线程
     * @param args      参数
     */
    void debug(String tag, String message, Thread t, Object... args);

    /**
     * debug: 传入一个Object对象
     * @param o
     */
    void error(Object o);

    void error(String message, Object... args);

    void error(String message, Thread t, Object... args);

    /**
     * debug
     * @param tag   标签
     * @param o     对象
     */
    void error(String tag, Object o);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param args      参数
     */
    void error(String tag, String message, Object... args);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param t         线程
     * @param args      参数
     */
    void error(String tag, String message, Thread t, Object... args);

    /**
     * debug: 传入一个Object对象
     * @param o
     */
    void warn(Object o);

    void warn(String message, Object... args);

    void warn(String message, Thread t, Object... args);

    /**
     * debug
     * @param tag   标签
     * @param o     对象
     */
    void warn(String tag, Object o);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param args      参数
     */
    void warn(String tag, String message, Object... args);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param t         线程
     * @param args      参数
     */
    void warn(String tag, String message, Thread t, Object... args);

    /**
     * debug: 传入一个Object对象
     * @param o
     */
    void fatal(Object o);

    void fatal(String message, Object... args);

    void fatal(String message, Thread t, Object... args);

    /**
     * debug
     * @param tag   标签
     * @param o     对象
     */
    void fatal(String tag, Object o);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param args      参数
     */
    void fatal(String tag, String message, Object... args);

    /**
     * debug
     * @param tag       标签
     * @param message   格式化字符串
     * @param t         线程
     * @param args      参数
     */
    void fatal(String tag, String message, Thread t, Object... args);

    /**
     * 生成日志前缀，例如：
     * 2019-08-24 13:48:44 java.lang.Object | toString: 235 - [INFO]: toString error
     *
     * @param level     级别名称，例如：INFO DEBUG ERROR
     * @return
     */
    String prefixGenerate(Level level);

    /**
     * 前缀生成，传入指定线程
     *
     * @param level
     * @param t
     * @return
     */
    String prefixGenerate(Level level, Thread t);
}
