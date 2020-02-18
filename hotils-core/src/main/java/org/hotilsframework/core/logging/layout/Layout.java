package org.hotilsframework.core.logging.layout;

import org.hotilsframework.core.logging.LifeCycle;
import org.hotilsframework.core.logging.LoggingEvent;

/**
 * 布局接口
 * @author hireny
 * @className Layout
 * @create 2020-02-17 23:13
 */
public interface Layout extends LifeCycle {
    /**
     * 对日志事件的布局
     * @param event
     * @return
     */
    String doLayout(LoggingEvent event);
}
