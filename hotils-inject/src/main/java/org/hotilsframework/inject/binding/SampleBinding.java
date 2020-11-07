package org.hotilsframework.inject.binding;

import org.hotilsframework.context.BeanContext;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.factory.InternalFactory;
import org.hotilsframework.inject.Scopes;
import org.hotilsframework.inject.factory.config.Scoping;
import org.hotilsframework.inject.internal.InternalInjector;

/**
 * SampleBinding
 *
 * 简单的绑定关系
 *
 * @author hireny
 * @create 2020-08-07 0:22
 */
public class SampleBinding<T> implements Binding<T> {

    /**
     * 该绑定关系所注入的注入器
     */
    private final InternalInjector injector;
    private final Key<T>                       key;
    /**
     * 作用域
     */
    private final Scope                      scope;
    /**
     * 内部工厂，用于生成对应的对象实例
     */
    private final InternalFactory<? extends T> internalFactory;

    public SampleBinding(InternalInjector injector, Key<T> key, Scope scope) {
        this.injector = injector;
        this.key = key;
        this.scope = scope;
        this.internalFactory = new Factory<>(key);
    }

    public SampleBinding(Key<T> key, Scope scope) {
        this(null, key, scope);
    }

    @Override
    public Key<T> getKey() {
        return key;
    }

    private volatile Provider<T> provider;

    @Override
    public Provider<T> getProvider() {
        System.out.println("绑定元素中注入器=" + injector);
        if (provider == null) {
            if (injector == null) {
                // 不支持模块绑定
                throw new UnsupportedOperationException("getProvider() not supported for module bindings");
            }
            System.out.println("获取提取者");
            provider= injector.getProvider(key);
        }
        System.out.println("已经具有绑定提供者=" + provider);
        return provider;
    }

    public InternalInjector getInjector() {
        return this.injector;
    }

    public InternalFactory<? extends T> getInternalFactory() {
        return this.internalFactory;
    }

    /**
     * 获取作用域
     * @return
     */
    @Override
    public Scope getScope() {
        return scope;
    }

    @Override
    public SampleBinding<T> withScope(Scope scope) {
        return new SampleBinding<>(getInjector(), getKey(), scope);
    }

    @Override
    public SampleBinding<T> withKey(Key<T> key) {
        return new SampleBinding<T>(getInjector(), key, getScope());
    }

    @Override
    public boolean isConstant() {
        return this instanceof InstanceBinding;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SampleBinding{");
        sb.append(", key=").append(key);
        sb.append(", scope=").append(scope);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 工厂
     * @param <T>
     */
    private static class Factory<T> implements InternalFactory<T> {

        private final Key<T> key;

        private Factory(Key<T> key) {
            this.key = key;
        }

        @Override
        public T get(BeanContext beanContext) {

            System.out.println("进入工厂1111=" + key);

            // 可以先从单例中获取
            T t = null;
            SampleBinding<T> binding = beanContext.getBinding(key);
            System.out.println("获取的信息=" + binding);

            // 可以先从容器中获取实例

            // 进行实例化
            if (binding instanceof LinkedBinding) {

                System.out.println("binding=" + binding);

                LinkedBinding<T> c = (LinkedBinding<T>) binding;


                t = beanContext.get(c.getTargetKey(), Scopes.getScopeTypes().get(binding.scope));
            }

            return t;
        }
    }
}
