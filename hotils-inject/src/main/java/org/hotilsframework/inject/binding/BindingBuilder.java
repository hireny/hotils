package org.hotilsframework.inject.binding;

import org.hotilsframework.inject.*;
import org.hotilsframework.inject.Scopes;
import org.hotilsframework.inject.qualifier.Qualifier;
import org.hotilsframework.inject.qualifier.Qualifiers;
import org.hotilsframework.lang.Assert;

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

    protected       List<Binding<?>> elements;
    protected       int              position;
    protected final Binder           binder;
    private         SampleBinding<T> binding;

    public BindingBuilder(Binder binder, List<Binding<?>> elements, Key<T> key) {
        this.binder = binder;
        this.elements = elements;
        this.position = elements.size();
        // 创建绑定信息 /默认原型作用域
        this.binding = new SampleBinding<T>(key, Scopes.PROTOTYPE);
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
        Assert.notNull(qualifier, "qualifier is not null.");
        setBinding(binding.withKey(Key.get(this.binding.getKey().getType(), qualifier)));
        return this;
    }

    @Override
    public BindingBuilder<T> annotatedWith(Annotation annotation) {
        return annotatedWith(Qualifiers.byAnnotation(annotation));
    }

    /**
     * 使用该方法实现绑定，默认使用单例作用域
     * @param implementation
     * @return
     */
    @Override
    public BindingBuilder<T> to(Class<? extends T> implementation) {
        Assert.notNull(implementation, "implementation is not null.");
        Key<? extends T> targetKey = Key.get(implementation);
        SampleBinding<T> binding = getBinding();
        System.out.println(binding.getScope());
        // 默认使用单例作用域
        setBinding(new LinkedBinding<T>(binding.getInjector(),binding.getKey(), binding.getScope(), targetKey));
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
        Assert.notNull(scopeType, "scope annotation is not null.");
        setBinding(getBinding().withScope(Scope.forAnnotation(scopeType)));
    }
}
