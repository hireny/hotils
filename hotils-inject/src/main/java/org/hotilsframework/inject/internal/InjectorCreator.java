package org.hotilsframework.inject.internal;

import org.hotilsframework.inject.Configuration;
import org.hotilsframework.inject.Injector;
import org.hotilsframework.lang.Assert;

/**
 * InjectorCreator
 *
 * 内部注入器创建器
 * 相当于对依赖注入进行配置
 *
 * @author hireny
 * @create 2020-07-26 12:01
 */
public class InjectorCreator {

    private InternalWrapper.Builder builder = new InternalWrapper.Builder();
    private InternalWrapper wrapper;


    public InjectorCreator addModules(Iterable<Configuration> modules) {
        builder.addModules(modules);
        return this;
    }

    /**
     * 构建
     * @return
     */
    public Injector build() {
        if (builder == null) {
            // 构建器已经构建，构建器是不可重用的
            throw new AssertionError("Already built, builders are not reusable.");
        }
        // 进行构建之前加锁
        synchronized (builder.lock()) {
            wrapper = builder.build();
        }
        return getInjector();
    }

    /**
     * 获取绑定器
     * @return
     */
    private Injector getInjector() {
        // 注入器为空
        Assert.notNull(wrapper, "injector wrapper is not null.");
        return wrapper.getInjector();
    }
}
