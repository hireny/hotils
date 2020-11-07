package org.hotilsframework.jcl;

/**
 * 日志记录器
 * @author hireny
 * @className Loggers
 * @create 2020-02-17 23:01
 */
public final class Loggers {
    private LoggerContext loggerContext;

    protected Loggers() {
        ContextInitializer.autoConfig();
        loggerContext = ContextInitializer.getDefaultLoggerContext();
    }

    public Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public Logger getLogger(String name) {
        Logger logger = loggerContext.getLoggerCache().get(name);
        if (null == logger) {
            logger = newLogger(name);
        }
        return logger;
    }

    public Logger newLogger(String name) {
        DefaultLogger logger = new DefaultLogger(name);
        Logger parent = null;
        // 拆分包名，向上查找 parent logger
        for (int i = name.lastIndexOf("."); i >= 0; i = name.lastIndexOf(".", i-1)) {
            String parentName = name.substring(0, i);
            parent = loggerContext.getLoggerCache().get(parentName);
            if (null != parent) {
                break;
            }
        }
        if (null == parent) {
            parent = loggerContext.getRoot();
        }
        logger.setParent(parent);
        logger.setLoggerContext(loggerContext);
        return logger;
    }
}
