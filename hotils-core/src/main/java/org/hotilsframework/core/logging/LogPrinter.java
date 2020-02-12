package org.hotilsframework.core.logging;

/**
 * 日志树接口
 * @ClassName: Printer
 * @Author: hireny
 * @Date: Created in 2020-02-10 21:55
 * @Version: 1.0
 */
public interface LogPrinter {

    void trace(String message, Object... args);

    void debug(String message, Object... args);

    void info(String message, Object... args);

    void warn(String message, Object... args);

    void error(String message, Object... args);
}
