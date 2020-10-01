package org.hotilsframework.jcl;


import org.hotilsframework.jcl.layout.Layout;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 输出源的抽象类
 * @author hireny
 * @className AbstractAppender
 * @create 2020-02-17 21:43
 */
public abstract class AbstractAppender implements Appender, LifeCycle {
    /**
     * 日志布局
     */
    protected Layout          layout;
    /**
     * 日志级别过滤器
     */
    protected List<LogFilter> filterList;
    /**
     * 编码
     */
    protected String encoding = Charset.defaultCharset().name();
    /**
     * 输出源名称
     */
    protected String name;
    /**
     * 锁对象
     */
    protected Object lock = new Object();

    @Override
    public void append(LoggingEvent event) {
        if (null != filterList) {
            for (LogFilter filter : filterList) {
                if (!filter.doFilter(event)) {
                    return;
                }
            }
        }
        String body = layout.doLayout(event);
        synchronized (lock) {
            doAppend(body);
        }
    }

    protected abstract void doAppend(String body);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public List<LogFilter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<LogFilter> filterList) {
        this.filterList = filterList;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
