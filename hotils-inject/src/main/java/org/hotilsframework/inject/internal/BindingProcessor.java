package org.hotilsframework.inject.internal;

import org.hotilsframework.inject.binding.Binding;
import org.hotilsframework.inject.BeanKey;
import org.hotilsframework.inject.binding.LinkedBinding;
import org.hotilsframework.inject.binding.SampleBinding;

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
        System.out.println("处理绑定关系中的注入器=" + this.injector);
        for (Iterator<Binding<?>> i = elements.iterator(); i.hasNext(); ) {
            Binding<?> binding = i.next();
            // 要处理绑定关系
            // 将绑定处理对象传入绑定对象中，交给元素处理
//            boolean allDone = binding.acceptVisitor(this);
            putBinding(binding);
        }
    }

    /**
     * 存放Binding信息
     * @param binding
     */
    protected <T> void putBinding(Binding<T> binding) {
        BeanKey<T> beanKey = binding.getBeanKey();

        SampleBinding<?> original = injector.getBinding(beanKey);
        System.out.println("原生=" + original);
        if (original != null) {
            // 存在以key为键的绑定信息
            return;
        }
        if (binding instanceof LinkedBinding) {

            binding = new LinkedBinding<T>(injector, binding.getBeanKey(), binding.getScope(),((LinkedBinding) binding).getTargetBeanKey());
        }

        // 在存进bean context 之前，要对 binding 进行处理
        injector.beanContext.putBinding(beanKey, (SampleBinding<?>) binding);
    }
}
