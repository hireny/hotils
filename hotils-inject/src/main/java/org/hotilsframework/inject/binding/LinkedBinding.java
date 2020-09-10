package org.hotilsframework.inject.binding;

import org.hotilsframework.inject.*;
import org.hotilsframework.inject.factory.config.Scope;
import org.hotilsframework.inject.internal.InternalInjector;

/**
 * ValueBinding
 *
 * 对Value进行绑定
 *
 * @author hireny
 * @create 2020-08-03 1:08
 */
public class LinkedBinding<T> extends SampleBinding<T> {

    /**
     * 目标键，是需要实例化的类的关键信息
     */
    final Key<? extends T> targetKey;

    public LinkedBinding(
            InternalInjector injector,
            Key<T> key,
            Scope scope,
            Key<? extends T> targetKey) {
        super(injector, key, scope);
        this.targetKey = targetKey;
    }

    public Key<? extends T> getTargetKey() {
        return targetKey;
    }

    @Override
    public LinkedBinding<T> withScope(Scope scope) {
        return new LinkedBinding<>(getInjector(),getKey(), scope, targetKey);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedBinding{");
        sb.append("key=").append(getKey());
        sb.append(", scope=").append(getScope());
        sb.append(", target=").append(getTargetKey());
        sb.append('}');
        return sb.toString();
    }
}
