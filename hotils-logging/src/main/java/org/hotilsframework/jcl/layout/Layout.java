package org.hotilsframework.jcl.layout;

import org.hotilsframework.jcl.LifeCycle;
import org.hotilsframework.jcl.LoggingEvent;

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
