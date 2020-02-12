package org.hotilsframework.core.logging;

/**
 * 日志工厂接口，所有的日志对象都根据这个接口标准
 * @ClassName: LoggerManager
 * @Author: hireny
 * @Date: Created in 2020-02-03 16:17
 * @Version: 1.0
 */
public class LoggerFactory {

    private LoggerContext loggerContext;

    private LoggerFactory() {
        loggerContext = ContextInitializer.getDefaultLoggerContext();
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.loggerContext.getLoggerCache().get(name);
        if (logger == null) {
            logger = loggerFactory.newLogger(name);
        }
        return logger;
    }

    private Logger newLogger(String name) {
        AbstractLogger logger = new DefaultLogger(name);
        logger.setName(name);
        return logger;
    }
}
