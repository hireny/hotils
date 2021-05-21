package org.hotilsframework.logging.appender;

import org.hotilsframework.logging.LogRunner;
import org.hotilsframework.logging.LoggingEvent;

/**
 * 输出源
 * @author hireny
 * @className Appender
 * @create 2020-02-17 21:39
 */
public interface Appender extends LogRunner {
    /**
     * 获取名称
     * @return
     */
    String getName();

    /**
     * 设置名称
     * @param name
     */
    void setName(String name);

    /**
     * 添加
     * @param event
     */
    void append(LoggingEvent event);
}
