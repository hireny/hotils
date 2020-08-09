package org.hotilsframework.inject.binder;

import org.hotilsframework.collect.Lists;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.factory.config.Scope;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * ModuleBinder
 *
 * 用于记录模块绑定的信息
 *
 * @author hireny
 * @create 2020-08-02 19:32
 */
public class ModuleBinder implements Binder {

    private final List<Module> modules;
    /**
     * 绑定的元素列表
     */
    private final List<Binding<?>>    elements;
    /**
     * The current modules stack
     *
     * 当前模块的堆栈信息
     */
    private ModuleSource moduleSource = null;


    public ModuleBinder() {
        this.modules = Lists.newArrayList();
        this.elements = Lists.newArrayList();
    }

    @Override
    public <T> BindingBuilder<T> bind(Key<T> key) {
        // 绑定元素的构建
        return new BindingBuilder<>(this, elements, key);
    }

    @Override
    public <T> BindingBuilder<T> bind(Class<T> type) {
        return bind(Key.get(type));
    }

    @Override
    public void bindScope(Class<? extends Annotation> annotationType, Scope scope) {
    }

    @Override
    public void install(Module module) {
        // 忽略相同模块实例的重复安装
        if (modules.contains(module)) {
            return;
        }
        ModuleBinder binder = this;
//        moduleSource = getModules(module.getClass());

        modules.add(module);
        module.configure(binder);
        binder.install(module);
    }

    /**
     * 获取所有的绑定元素
     * @return
     */
    public List<Binding<?>> getElements() {
        return elements;
    }

    private ModuleSource getModules(Class<?> module) {
        // 用于存储模块的调用堆栈信息
        StackTraceElement[] partialCallStack = new StackTraceElement[0];
        if (moduleSource == null) {
            return new ModuleSource(module, partialCallStack);
        }
        return null;
    }
}
