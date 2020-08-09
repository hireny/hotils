package org.hotilsframework.inject.binder;

import org.hotilsframework.inject.*;
import org.hotilsframework.inject.internal.LinkedBinding;
import org.hotilsframework.inject.internal.SampleBinding;
import org.hotilsframework.utils.Assert;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * BindingBuilder
 * 绑定元素的构建
 *
 * @author hireny
 * @create 2020-08-02 19:28
 */
public class BindingBuilder<T> implements BindingBuilderInterface<T> {

    protected List<Binding<?>> elements;
    protected int position;
    protected final Binder           binder;
    private         SampleBinding<T> binding;

    public BindingBuilder(Binder binder, List<Binding<?>> elements, Key<T> key) {
        this.binder = binder;
        this.elements = elements;
        this.position = elements.size();
        this.binding = new SampleBinding<>(key,Scopes.SINGLETON);
        elements.add(position, this.binding);
    }

    /**
     * 获取绑定信息
     * @return
     */
    protected SampleBinding<T> getBinding() {
        return binding;
    }

    /**
     * 设置绑定信息
     */
    protected SampleBinding<T> setBinding(SampleBinding<T> binding) {
        this.binding = binding;
        elements.set(position, binding);
        return binding;
    }

    @Override
    public BindingBuilder<T> annotatedWith(Qualifier qualifier) {
        return null;
    }

    @Override
    public BindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType) {
        return null;
    }

    /**
     * 使用该方法实现绑定，默认使用单例作用域
     * @param implementation
     * @return
     */
    @Override
    public BindingBuilder<T> to(Class<? extends T> implementation) {
        Key<? extends T> targetKey = Key.get(implementation);
        SampleBinding<T> binding = getBinding();
        System.out.println(binding.getScope());
        // 默认使用单例作用域
        setBinding(new LinkedBinding<T>(binding.getInjector(),binding.getKey(), binding.getInternalFactory(), binding.getScope(), targetKey));
        return this;
    }

    /**
     * 使用该方法实现绑定，默认使用原型模式
     * @param instance
     */
    @Override
    public void toInstance(T instance) {
        if (instance != null) {

        }
    }

    /**
     * 绑定作用域范围
     * @param scopeType
     */
    @Override
    public void in(Class<? extends Annotation> scopeType) {
        System.out.println("绑定作用域=" + scopeType);
        Assert.notNull(scopeType, "scope annotation is not null.");
        System.out.println("绑定Binding=" + getBinding());
        setBinding(getBinding().withScope(Scope.forAnnotation(scopeType)));
    }

    void registerInstanceForInjection(final Object o) {

    }
}
