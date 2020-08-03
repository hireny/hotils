package org.hotilsframework.inject.internal;

import org.hotilsframework.collect.Lists;
import org.hotilsframework.context.BeanContext;
import org.hotilsframework.context.DefaultBeanContext;
import org.hotilsframework.inject.*;
import org.hotilsframework.utils.Assert;

import javax.inject.Singleton;
import java.util.List;
import java.util.Objects;

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
        private final List<Binding<?>> elements = Lists.newArrayList();
        /**
         * 模块信息
         */
        private final List<Module>     modules = Lists.newArrayList();
        /**
         * bean上下文
         */
        private       BeanContext      beanContext;
        /**
         * 父的注入器
         */
        private       InternalInjector parent;

        Builder parent(InternalInjector parent) {
            this.parent = parent;
            this.beanContext = new DefaultBeanContext(parent.beanContext);
            return this;
        }

        void addModules(Iterable<? extends Module> modules) {
            modules.forEach(this.modules::add);
        }

        /**
         * 获得锁
         * @return
         */
        Object lock() {
            return getBeanContext().lock();
        }

        InternalWrapper build() {
            // 没有上下文，你记得加锁了吗？
            Assert.state(beanContext != null, "no bean context. Did you remember to lock() ?");
            // 通过模块信息获取所有的绑定信息并存储在集合中
            elements.addAll(Bindings.getBindings(modules));
            System.out.println(beanContext);
            // 创建注入器
            InternalInjector injector = new InternalInjector(parent, beanContext);

            // 如果parent是顶级注入器，可以添加默认的类型转换器，本人没有实现

            new BindingProcessor().process(injector, elements);

            InternalWrapper wrapper = new InternalWrapper(elements, injector);

            return wrapper;
        }

        private BeanContext getBeanContext() {
            if (beanContext == null) {
                beanContext = new DefaultBeanContext(BeanContext.NONE);
            }
            return beanContext;
        }
    }


    private static class RootModule implements Module {

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
