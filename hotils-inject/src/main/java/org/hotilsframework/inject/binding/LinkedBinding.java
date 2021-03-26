package org.hotilsframework.inject.binding;

import org.hotilsframework.inject.*;
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
    final BeanKey<? extends T> targetBeanKey;

    public LinkedBinding(
            InternalInjector injector,
            BeanKey<T> beanKey,
            Scope scope,
            BeanKey<? extends T> targetBeanKey) {
        super(injector, beanKey, scope);
        this.targetBeanKey = targetBeanKey;
    }

    public BeanKey<? extends T> getTargetBeanKey() {
        return targetBeanKey;
    }

    @Override
    public LinkedBinding<T> withScope(Scope scope) {
        return new LinkedBinding<>(getInjector(), getBeanKey(), scope, targetBeanKey);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedBinding{");
        sb.append("key=").append(getBeanKey());
        sb.append(", scope=").append(getScope());
        sb.append(", target=").append(getTargetBeanKey());
        sb.append('}');
        return sb.toString();
    }
}
