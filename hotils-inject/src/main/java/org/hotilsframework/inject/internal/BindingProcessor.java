package org.hotilsframework.inject.internal;

import org.hotilsframework.inject.Binding;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.internal.InternalInjector;

import java.util.Iterator;
import java.util.List;

/**
 * BindingProcessor
 *
 * 绑定信息处理
 *
 * @author hireny
 * @create 2020-08-03 11:53
 */
public class BindingProcessor {

    protected InternalInjector injector;

    public BindingProcessor() {}

    /**
     * 对注入器和绑定信息进行处理
     * @param injector
     * @param elements
     */
    public void process(InternalInjector injector, List<Binding<?>> elements) {
        this.injector = injector;
        for (Iterator<Binding<?>> i = elements.iterator(); i.hasNext(); ) {
            Binding<?> binding = i.next();
            // 要处理绑定关系
            // 将绑定处理对象传入绑定对象中，交给元素处理
            putBinding(binding);
        }
    }

    /**
     * 存放Binding信息
     * @param binding
     */
    protected void putBinding(Binding<?> binding) {
        Key<?> key = binding.getKey();

        Binding<?> original = injector.getBinding(key);
        System.out.println("原生=" + original);
        if (original != null) {
            // 存在以key为键的绑定信息
            return;
        }
        // 在存进bean context 之前，要对 binding 进行处理
        injector.beanContext.putBinding(key, binding);
    }

    /**
     * 对绑定的元素基础
     * @param binding
     * @param <T>
     * @return
     */
    public <T> Boolean visit(Binding<T> binding) {
        // 可以先判断
//        return new Processor<T, Boolean>(binding) {};
        return true;
    }
}
