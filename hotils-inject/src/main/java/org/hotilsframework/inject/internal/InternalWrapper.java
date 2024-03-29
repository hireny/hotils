package org.hotilsframework.inject.internal;

import org.hotilsframework.collect.ListUtils;
import org.hotilsframework.context.Context;
import org.hotilsframework.context.DefaultContext;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.Binder;
import org.hotilsframework.inject.binding.Binding;
import org.hotilsframework.inject.binding.Bindings;
import org.hotilsframework.lang.Assert;

import javax.inject.Singleton;
import java.util.List;

import static org.hotilsframework.inject.Scopes.SINGLETON;

/**
 * InternalInjectors
 *
 * 内部的注入器包装
 *
 * @author hireny
 * @create 2020-08-02 0:10
 */
public class InternalWrapper {

    private final List<Binding<?>> elements;
    private final InternalInjector injector;

    public InternalWrapper(List<Binding<?>> elements, InternalInjector injector) {
        this.elements = elements;
        this.injector = injector;
    }

    InternalInjector getInjector() {
        return injector;
    }

    List<Binding<?>> getElements() {
        return elements;
    }

    /**
     * 对注入器进行构建
     */
    static class Builder {
        /**
         * 存储绑定信息的元素
         */
        private final List<Binding<?>>    elements       = ListUtils.newArrayList();
        /**
         * 模块信息
         */
        private final List<Configuration> configurations = ListUtils.newArrayList();
        /**
         * bean上下文
         */
        private       Context             context;
        /**
         * 父的注入器
         */
        private       InternalInjector parent;

        Builder parent(InternalInjector parent) {
            this.parent = parent;
            this.context = new DefaultContext(parent.context);
            return this;
        }

        void addModules(Iterable<? extends Configuration> modules) {
            modules.forEach(this.configurations::add);
        }

        /**
         * 获得锁
         * @return
         */
        Object lock() {
            return getContext().lock();
        }

        InternalWrapper build() {
            // 没有上下文，你记得加锁了吗？
            Assert.checkArgument(context != null, "no bean context. Did you remember to lock() ?");
            // 通过模块信息获取所有的绑定信息并存储在集合中
            elements.addAll(Bindings.getBindings(configurations));
            System.out.println("绑定元素曝光=" + elements.toString());
            // 创建注入器
            InternalInjector injector = new InternalInjector(parent, context);

            // 如果parent是顶级注入器，可以添加默认的类型转换器，本人没有实现

            // 绑定处理器处理注入器与绑定元素
            new BindingProcessor().process(injector, elements);

            InternalWrapper wrapper = new InternalWrapper(elements, injector);

            return wrapper;
        }

        // 获取Bean上下文
        private Context getContext() {
            if (context == null) {
                context = new DefaultContext(Context.NONE);
            }
            return context;
        }
    }


    private static class RootConfiguration implements Configuration {

        @Override
        public void configure(Binder binder) {
            binder.bindScope(Singleton.class, SINGLETON);
        }
    }

//    private static class InheritedModule implements Module {
//
//        private final BeanContext context;
//
//        private InheritedModule(BeanContext context) {
//            this.context = context;
//        }
//
//        @Override
//        public void configure(Binder binder) {
//
//        }
//    }
}
