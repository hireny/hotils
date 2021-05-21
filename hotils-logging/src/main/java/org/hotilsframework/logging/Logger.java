package org.hotilsframework.logging;

/**
 * 日志接口的定义
 * @ClassName: Logger
 * @Author: hireny
 * @Date: Created in 2020-02-03 16:16
 * @Version: 1.0
 */
public interface Logger {

    String getName();

    /**
     * 级别判定 是否可TRACE
     * @return  {@code true} 可以；{@code false} 不能。
     */
    boolean isTraceEnabled();
    void trace(String message);

    /**
     * 判定级别 是否可DEBUG
     * @return  {@code true} 可以；{@code false} 不能。
     */
    boolean isDebugEnabled();
    void debug(String message);

    /**
     * 判定级别 是否可INFO
     * @return  {@code true} 可以；{@code false} 不能。
     */
    boolean isInfoEnabled();
    void info(String message);

    /**
     * 判定级别 是否WARNING
     * @return  {@code true} 可以；{@code false} 不能。
     */
    boolean isWarnEnabled();
    void warn(String message);

    /**
     * 判定级别 是否可ERROR
     * @return  {@code true} 可以；{@code false} 不能。
     */
    boolean isErrorEnabled();
    void error(String message);

    /**
     * 判定级别 是否可FATAL
     * @return  {@code true} 可以；{@code false} 不能。
     */
    boolean isFatalEnabled();
    void fatal(String message);
}
