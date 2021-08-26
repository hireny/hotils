package org.hotilsframework.inject.binding;

import org.hotilsframework.collect.ListUtils;
import org.hotilsframework.inject.*;

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

    public static List<Binding<?>> getBindings(Configuration... configurations) {
        return getBindings(Arrays.asList(configurations));
    }

    public static List<Binding<?>> getBindings(Iterable<? extends Configuration> modules) {
        RecordBinder binder = new RecordBinder();
        modules.forEach(binder::install);
        return Collections.unmodifiableList(binder.getElements());
    }

    /**
     * 记录绑定信息
     */
    private static class RecordBinder implements Binder {
        private final List<Configuration> configurations;
        /**
         * 绑定的元素列表
         */
        private final List<Binding<?>>    elements;


        public RecordBinder() {
            this.configurations = ListUtils.newArrayList();
            this.elements = ListUtils.newArrayList();
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
        public void install(Configuration configuration) {
            // 忽略相同模块实例的重复安装
            if (configurations.contains(configuration)) {
                return;
            }
            RecordBinder binder = this;
//        moduleSource = getModules(module.getClass());

            configurations.add(configuration);
            configuration.configure(binder);
            binder.install(configuration);
        }

        /**
         * 获取所有的绑定元素
         * @return
         */
        public List<Binding<?>> getElements() {
            return elements;
        }
    }
}
