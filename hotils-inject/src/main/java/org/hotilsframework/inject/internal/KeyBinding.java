package org.hotilsframework.inject.internal;

import org.hotilsframework.inject.*;

/**
 * KeyBinding
 *
 * 只绑定Key的绑定元素
 *
 * @author hireny
 * @create 2020-08-03 1:06
 */
public class KeyBinding<T> implements Binding<T> {
    private static final long serialVersionUID = -3311706366295195792L;

    private final Key<T> key;
    /**
     * 内部工厂，用于生产对象
     */
    private final BeanElements beanElements;
    /**
     * 作用域
     */
    private final Scope scope;

    public KeyBinding(Key<T> key, BeanElements beanElements, Scope scope) {
        this.key = key;
        this.beanElements = beanElements;
        this.scope = scope;
    }

    @Override
    public Key<T> getKey() {
        return key;
    }

    @Override
    public Value<? extends T> getValue() {
        throw new UnsupportedOperationException("不支持该操作");
    }

    @Override
    public Provider<T> getProvider() {
        throw new UnsupportedOperationException("不支持该操作");
    }

    public BeanElements getBeanElements() {
        return beanElements;
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
    public KeyBinding<T> withScope(Scope scope) {
        throw new AssertionError("不支持该操作");
    }

    @Override
    public <V> V acceptTargetVisitor() {
        return null;
    }

    @Override
    public <V> V acceptScopingVisitor() {
        return null;
    }

    @Override
    public Object getElement() {
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KeyBinding{");
        sb.append("key=").append(key);
        sb.append(", scope=").append(scope);
        sb.append('}');
        return sb.toString();
    }
}
