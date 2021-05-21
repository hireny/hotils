package org.hotilsframework.logging.layout;

import org.hotilsframework.logging.LogRunner;
import org.hotilsframework.logging.LoggingEvent;

/**
 * 布局接口
 * @author hireny
 * @className Layout
 * @create 2020-02-17 23:13
 */
public interface Layout extends LogRunner {
    /**
     * 对日志事件的布局
     * @param event
     * @return
     */
    String doLayout(LoggingEvent event);
}
