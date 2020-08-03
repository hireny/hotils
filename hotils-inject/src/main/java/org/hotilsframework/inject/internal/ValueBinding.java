package org.hotilsframework.inject.internal;

import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.Provider;
import org.hotilsframework.inject.Providers;
import org.hotilsframework.inject.Value;

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

    public ValueBinding(Key<T> key, Value<? extends T> value) {
        super(key);
        this.value = value;
    }

    @Override
    public Value<? extends T> getValue() {
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Provider<T> getProvider() {
        // 将value进行实例化
        return (Provider<T>) Providers.of(value.getType());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValueBinding{");
        sb.append("key=").append(getKey());
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
