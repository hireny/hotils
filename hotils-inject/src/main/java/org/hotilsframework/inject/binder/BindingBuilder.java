package org.hotilsframework.inject.binder;

import org.hotilsframework.inject.*;
import org.hotilsframework.inject.internal.KeyBinding;
import org.hotilsframework.inject.internal.ValueBinding;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;

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
    protected final Binder        binder;
    private         Binding<T> binding;

    public BindingBuilder(Binder binder, List<Binding<?>> elements, Key<T> key) {
        this.binder = binder;
        this.elements = elements;
        this.position = elements.size();
        this.binding = new KeyBinding<>(key);
        elements.add(position, this.binding);
    }

    /**
     * 获取绑定信息
     * @return
     */
    protected Binding<T> getBinding() {
        return binding;
    }

    /**
     * 设置绑定信息
     */
    protected Binding<T> setBinding(Binding<T> binding) {
        this.binding = binding;
        elements.set(position, binding);
        return binding;
    }

    @Override
    public BindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType) {
        return null;
    }

    /**
     * 使用该方法实现绑定，默认使用单例模式
     * @param implementation
     * @return
     */
    @Override
    public BindingBuilder<T> to(Class<? extends T> implementation) {
        Value<? extends T> value = Value.get(implementation);
        Binding<T> binding = getBinding();
        setBinding(new ValueBinding<T>(binding.getKey(), value));
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

    @Override
    public void in(Class<? extends Annotation> scopeAnnotation) {

    }

    @Override
    public void in(Scope scope) {

    }

    void registerInstanceForInjection(final Object o) {

    }
}
