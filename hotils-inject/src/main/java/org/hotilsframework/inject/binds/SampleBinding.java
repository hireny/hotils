package org.hotilsframework.inject.binds;

import org.hotilsframework.context.BeanContext;
import org.hotilsframework.core.reflects.Instantiator;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.factory.InternalFactory;
import org.hotilsframework.inject.factory.config.Scope;
import org.hotilsframework.inject.factory.config.Scopes;
import org.hotilsframework.inject.internal.InternalInjector;
import org.hotilsframework.inject.spi.InstanceBinding;

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
    private final Key<T>           key;
    /**
     * 作用域
     */
    private final Scope                        scope;
    /**
     * 内部工厂，用于生成对应的对象实例
     */
    private final InternalFactory<? extends T> internalFactory;

    public SampleBinding(InternalInjector injector, Key<T> key,InternalFactory<? extends T> internalFactory, Scope scope) {
        this.injector = injector;
        this.key = key;
        this.scope = scope;
        this.internalFactory = internalFactory == null ? new Factory<>(key) : internalFactory;
    }

    public SampleBinding(Key<T> key, Scope scope) {
        this(null, key, null,scope);
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
        throw new AssertionError("不支持该操作");
    }

    @Override
    public SampleBinding<T> withKey(Key<T> key) {
        throw new AssertionError("不支持该操作");
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

            System.out.println("进入工厂");

            // 可以先从单例中获取
            T t = null;
            SampleBinding<T> binding = beanContext.getBinding(key);

            // 可以先从容器中获取实例

            // 进行实例化
            if (binding instanceof LinkedBinding) {

                System.out.println("binding=" + binding);

                LinkedBinding<T> c = (LinkedBinding<T>) binding;

                // 判断是否为单例
                if (Scopes.SINGLETON.equals(binding.scope)) {
                    t = beanContext.get(c.getTargetKey());
                    System.out.println("单例对象查看=" + t);
                }

                if (t == null) {
                    System.out.println("开始实例化");
                    t = Instantiator.tryInstance(((LinkedBinding) binding).getTargetKey().getType());
                }
            }

            return t;
        }
    }
}
