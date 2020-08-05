package org.hotilsframework.inject.internal;

import org.hotilsframework.inject.*;

/**
 * ValueBinding
 *
 * 对Value进行绑定
 *
 * @author hireny
 * @create 2020-08-03 1:08
 */
public class ValueBinding<T> extends KeyBinding<T> {
    private static final long serialVersionUID = 5835941052389145655L;
    private final Value<? extends T> value;

    public ValueBinding(Key<T> key, Value<? extends T> value, BeanElements beanElements, Scope scope) {
        super(key, beanElements, scope);
        this.value = value;
    }

    @Override
    public Value<? extends T> getValue() {
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Provider<T> getProvider() {
        // 首先判断是否是单例作用域
        if (Scopes.SINGLETON.equals(super.getScope())) {
            // 单例作用域，那么首先就要判断是否能从容器中获取对象
            // 要将Value转换为Key
            Key<? extends T> key = Key.get(getValue().getType());
            return (Provider<T>) getBeanElements().getProvider(key);
        }
        // 将value进行实例化
        return (Provider<T>) Providers.of(value.getType());
    }

    @Override
    public ValueBinding<T> withScope(Scope scope) {
        return new ValueBinding<>(getKey(), getValue(), getBeanElements(), scope);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValueBinding{");
        sb.append("key=").append(getKey());
        sb.append(", value=").append(value);
        sb.append(", scope=").append(getScope());
        sb.append('}');
        return sb.toString();
    }
}
