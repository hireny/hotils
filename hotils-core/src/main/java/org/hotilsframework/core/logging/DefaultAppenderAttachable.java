package org.hotilsframework.core.logging;

import org.hotilsframework.collection.Lists;

import java.util.List;

/**
 * 默认实现的可连接的输出源
 * @author hireny
 * @className DefaultAppenderAttachable
 * @create 2020-02-17 23:18
 */
public class DefaultAppenderAttachable implements AppenderAttachable {

    private final List<Appender> appenders = Lists.newCopyOnWriteArrayList();

    /**
     * 在输出源中追加日志事件
     * @param event
     * @return
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int size = 0;
        Appender appender;

        size = appenders.size();
        for (int i = 0; i < size; i++) {
            appender = appenders.get(i);
            appender.append(event);
        }
        return size;
    }

    @Override
    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    @Override
    public Appender getAppender(String name) {
        if (null == name) {
            return null;
        }
        for (Appender appender : appenders) {
            if (name.equals(appender.getName())) {
                return appender;
            }
        }
        return null;
    }

    @Override
    public boolean isAttached(Appender appender) {
        if (null == appender) {
            return false;
        }
        for (Appender a : appenders) {
            if (a == appender) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAppender(Appender appender) {
        removeAppender(appender.getName());
    }

    @Override
    public void removeAppender(String name) {
        if (null == name) {
            return;
        }
        for (Appender appender : appenders) {
            if (name.equals(appender.getName())) {
                appenders.remove(appender);
                break;
            }
        }
    }
}
