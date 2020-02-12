package org.hotilsframework.core.logging;

/**
 * @ClassName: DefaultLogger
 * @Author: hireny
 * @Date: Created in 2020-02-11 22:38
 * @Version: 1.0
 */
public class DefaultLogger extends AbstractLogger {

    public DefaultLogger(String name) {
        super(name);
    }

    @Override
    public void trace(String message) {
        logPrint(Level.TRACE, message);
    }

    @Override
    public void debug(String message) {
        logPrint(Level.DEBUG, message);
    }

    @Override
    public void info(String message) {
        logPrint(Level.INFO, message);
    }

    @Override
    public void warn(String message) {
        logPrint(Level.WARN, message);
    }

    @Override
    public void error(String message) {
        logPrint(Level.ERROR, message);
    }

    @Override
    public void fatal(String message) {
        logPrint(Level.FATAL, message);
    }
}
