package org.hotilsframework.jcl;

import org.hotilsframework.collect.Maps;

import java.util.Map;
import java.util.StringJoiner;

/**
 * 一个全局的上下文对象
 * @className LogContext
 * @author hireny
 * @create 2020-02-17 21:03
 */
public class LoggerContext {
    /**
     * 根日志记录器
     */
    private Logger root;
    /**
     * logger缓存，存放解析配置文件后生成的logger对象，以及通过程序手动创建的logger对象
     */
    private Map<String, Logger> loggerCache = Maps.newHashMap();

    public void addLogger(String name, Logger logger) {
        loggerCache.put(name, logger);
    }

    public void addLogger(Logger logger) {
        addLogger(logger.getName(), logger);
    }

    public Logger getRoot() {
        return root;
    }

    public void setRoot(Logger root) {
        this.root = root;
    }

    public Map<String, Logger> getLoggerCache() {
        return loggerCache;
    }

    public void setLoggerCache(Map<String, Logger> loggerCache) {
        this.loggerCache = loggerCache;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LoggerContext.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("loggerCache=" + loggerCache)
                .toString();
    }
}
