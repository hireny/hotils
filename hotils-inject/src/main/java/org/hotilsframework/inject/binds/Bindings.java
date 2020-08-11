package org.hotilsframework.inject.binds;

import org.hotilsframework.collect.Lists;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.binds.binder.BindingBuilder;
import org.hotilsframework.inject.factory.config.Scope;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Bindings
 *
 * 根据模块信息获取绑定元素的注册器
 *
 * @author hireny
 * @create 2020-08-02 18:33
 */
public class Bindings {

    public static List<Binding<?>> getBindings(Module... modules) {
        return getBindings(Arrays.asList(modules));
    }

    public static List<Binding<?>> getBindings(Iterable<? extends Module> modules) {
        RecordBinder binder = new RecordBinder();
        modules.forEach(binder::install);
        return Collections.unmodifiableList(binder.getElements());
    }

    /**
     * 记录绑定信息
     */
    private static class RecordBinder implements Binder {
        private final List<Module>     modules;
        /**
         * 绑定的元素列表
         */
        private final List<Binding<?>> elements;
        /**
         * The current modules stack
         *
         * 当前模块的堆栈信息
         */
        private       ModuleSource     moduleSource = null;


        public RecordBinder() {
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
            RecordBinder binder = this;
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
}
