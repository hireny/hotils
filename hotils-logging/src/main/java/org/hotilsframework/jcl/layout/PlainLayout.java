package org.hotilsframework.jcl.layout;

import org.hotilsframework.jcl.LoggingEvent;

/**
 * 无格式的纯文本布局直接调用 {@link LoggingEvent#toString()}
 * @author hireny
 * @className PlainLayout
 * @create 2020-02-17 23:15
 */
public class PlainLayout implements Layout {
    @Override
    public String doLayout(LoggingEvent event) {
        return event.toString();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
