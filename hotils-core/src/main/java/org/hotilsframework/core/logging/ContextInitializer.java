package org.hotilsframework.core.logging;

/**
 * 上下文初始化
 * @ClassName: ContextInitializer
 * @Author: hireny
 * @Date: Created in 2020-02-12 17:58
 * @Version: 1.0
 */
public class ContextInitializer {

    private static final LoggerContext DEFAULT_LOGGER_CONTEXT = new LoggerContext();

    public static LoggerContext getDefaultLoggerContext() {
        return DEFAULT_LOGGER_CONTEXT;
    }
}
