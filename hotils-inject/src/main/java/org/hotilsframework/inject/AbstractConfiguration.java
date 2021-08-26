package org.hotilsframework.inject;

import org.hotilsframework.inject.binding.BindingBuilder;
import org.hotilsframework.inject.factory.config.Scoping;
import org.hotilsframework.lang.Assert;

import java.lang.annotation.Annotation;

/**
 * @author hireny
 * @className AbstractModule
 * @create 2020-05-17 23:23
 */
public abstract class AbstractConfiguration implements Configuration {
    /**
     * 绑定者
     */
    Binder binder;

    @Override
    public void configure(Binder binder) {
        Assert.checkState(this.binder == null, "Re-entry is not allowed.");

        this.binder = Assert.notNull(binder, "builder");
        try {
            configure();
        } finally {
            this.binder = null;
        }
    }


    public void configure() {

    }

    protected Binder binder() {
        Assert.checkState(binder != null, "The binder can only be used inside configure()");
        return binder;
    }

    protected void bindScope(Class<? extends Annotation> scopeAnnotation, Scoping scope) {
        binder().bindScope(scopeAnnotation, scope);
    }

    protected <T> BindingBuilder<T> bind(Class<T> type) {
        return binder().bind(type);
    }
}
