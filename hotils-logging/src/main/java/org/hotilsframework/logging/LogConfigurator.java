package org.hotilsframework.logging;

/**
 * 配置器接口
 * @author hireny
 * @className Configurator
 * @create 2020-02-17 22:11
 */
public interface LogConfigurator extends LogRunner {
    /**
     * 配置执行
     */
    void doConfigure();
}
