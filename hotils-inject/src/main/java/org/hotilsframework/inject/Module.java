package org.hotilsframework.inject;

import org.hotilsframework.inject.binds.Binder;

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
