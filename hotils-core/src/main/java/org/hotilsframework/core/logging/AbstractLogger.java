package org.hotilsframework.core.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 抽象的日志实现
 * @ClassName: AbstractLogger
 * @Author: hireny
 * @Date: Created in 2020-02-11 22:39
 * @Version: 1.0
 */
public abstract class AbstractLogger implements Logger {
    /**
     * 完全限定名 full
     */
    private String name;


    public AbstractLogger(String name) {
        this.setName(name);
    }

    /**
     * 获取完全限定名
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置完全限定名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public abstract void trace(String message);

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public abstract void debug(String message);

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public abstract void info(String message);

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public abstract void warn(String message);

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public abstract void error(String message);

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public abstract void fatal(String message);

    /**
     * 日志打印
     * @param level     日志级别
     * @param message   日志信息
     */
    protected void logPrint(Level level, String message) {
        System.out.printf("%-4s %1s %-5s %5s %-52s %1s %-6s%n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()), " ", level, " ", name, ":", message);
    }
}
