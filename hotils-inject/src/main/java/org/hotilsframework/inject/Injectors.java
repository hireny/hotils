package org.hotilsframework.inject;

import org.hotilsframework.inject.internal.InjectorCreator;

import java.util.Arrays;

/**
 * Injectors
 *
 * 该方法就相当于注入器的工厂类，用于生产注入器的
 * @author hireny
 * @create 2020-05-15 22:19
 */
public class Injectors {

    private Injectors() {}

    /**
     * 创建注入对象
     * @param modules
     * @return
     */
    public static Injector createInjector(Module... modules) {
        return createInjector(Arrays.asList(modules));
    }

    /**
     * 创建注入对象
     * @param modules
     * @return
     */
    public static Injector createInjector(Iterable<Module> modules) {
        return new InjectorCreator().addModules(modules).build();
    }
}
