package org.hotilsframework.core.logging;

import java.net.URL;

/**
 * 默认配置
 * @author hireny
 * @className DefaultCOnfigurator
 * @create 2020-02-18 10:55
 */
public class DefaultConfigurator implements Configurator {

    private final URL url;
    private final LoggerContext loggerContext;

    DefaultConfigurator(URL url, LoggerContext loggerContext) {
        this.url = url;
        this.loggerContext = loggerContext;
    }

    @Override
    public void doConfigure() {
        parse();
    }

    /**
     * 解析
     */
    private void parse() {
        parseRoot();
    }


    /**
     * 解析根日志记录器
     */
    private void parseRoot() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
