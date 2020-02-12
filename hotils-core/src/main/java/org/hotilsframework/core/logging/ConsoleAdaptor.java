package org.hotilsframework.core.logging;

import com.sun.deploy.util.ArrayUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ConsoleAdaptor
 * @Author: hireny
 * @Date: Created in 2020-02-12 13:44
 * @Version: 1.0
 */
public class ConsoleAdaptor implements Logger {

    /**
     * 类信息
     */
    private String name;

    public ConsoleAdaptor(String name) {
        this.name = name;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(String message) {
        write(Level.TRACE, message, null);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String message) {
        write(Level.DEBUG, message, null);
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String message) {
        write(Level.INFO, message, null);
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String message) {
        write(Level.WARN, message, null);
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String message) {
        write(Level.ERROR, message, null);
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(String message) {
        write(Level.FATAL, message, null);
    }

    /**
     * 消息打印
     * @param level         消息等级
     * @param message       消息内容
     * @param throwable     异常
     */
    private void write(Level level, String message, Throwable throwable) {
        StackTraceElement callMethodElement = Thread.currentThread().getStackTrace()[3];
        final String className = name;
        final String methodName = callMethodElement.getMethodName();
        final String threadName = Thread.currentThread().getName();

        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String log = String.format("[%s] [%s] [%s] - %s", level, dateString, threadName, message);
        System.out.println(log);

        if (throwable != null) {
            throwable.printStackTrace(System.err);
        }
    }

}
