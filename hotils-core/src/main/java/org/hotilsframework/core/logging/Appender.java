package org.hotilsframework.core.logging;

/**
 * 输出源
 * @ClassName: Handler
 * @Author: hireny
 * @Date: Created in 2020-02-11 22:35
 * @Version: 1.0
 */
public interface Appender {
    /**
     * 获取输出源名称
     * @return
     */
    String getName();

    /**
     * 设置输出源名称
     * @param name
     */
    void setName(String name);

    /**
     * 添加输出事件
     * @param event
     */
    void append(LoggingEvent event);
}
