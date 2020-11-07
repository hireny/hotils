package org.hotilsframework.jcl;

import java.net.URL;

/**
 * 上下文初始化
 * @author hireny
 * @className ContextInitializer
 * @create 2020-02-17 22:05
 */
public class ContextInitializer {

    final public static String AUTOCONFIG_FILE = "loghotils.xml";
    final public static String YAML_FILE = "loghotils.yml";

    private static final LoggerContext DEFAULT_LOGGER_CONTEXT;

    static {
        DEFAULT_LOGGER_CONTEXT = new LoggerContext();
    }

    /**
     * 自动配置
     */
    public static void autoConfig() {
        URL url =getConfigUrl();
        if (null == url) {
            System.err.println("config[loghotils.xml or loghotils.yml] file not found!");
            return;
        }
        String urlString = url.toString();
        Configurator configurator = null;

        if (urlString.endsWith("xml")) {
            configurator = new XMLConfigurator(url, DEFAULT_LOGGER_CONTEXT);
        }
        configurator.doConfigure();
    }

    private static URL getConfigUrl() {
        URL url = null;
        ClassLoader classLoader = ContextInitializer.class.getClassLoader();
        url = classLoader.getResource(AUTOCONFIG_FILE);
        if (null != url) {
            return url;
        }
        url = classLoader.getResource(YAML_FILE);
        if (null != url) {
            return url;
        }
        return null;
    }

    public static LoggerContext getDefaultLoggerContext() {
        return DEFAULT_LOGGER_CONTEXT;
    }
}
