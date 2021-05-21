package org.hotilsframework.logging.appender;

/**
 * 可连接的输出源接口
 * @author hireny
 * @className AppenderAttachable
 * @create 2020-02-17 21:39
 */
public interface AppenderAttachable {
    /**
     * 添加输出源
     * @param appender      输出源
     */
    void addAppender(Appender appender);

    /**
     * 获取输出源
     * @param name      输出源名称
     * @return
     */
    Appender getAppender(String name);

    /**
     * 输出源是否可连接
     * @param appender      输出源
     * @return
     */
    boolean isAttached(Appender appender);

    /**
     * 移除输出源
     * @param appender      输出源
     */
    void removeAppender(Appender appender);

    /**
     * 移除输出源
     * @param name          输出源名称
     */
    void removeAppender(String name);
}
