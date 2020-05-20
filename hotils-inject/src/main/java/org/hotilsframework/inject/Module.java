package org.hotilsframework.inject;

/**
 * 一组Binder
 * @author hireny
 * @className Module
 * @create 2020-05-15 21:10
 */
public interface Module {
    /**
     * 配置
     * @param binder
     */
    void configure(Binder binder);
}
