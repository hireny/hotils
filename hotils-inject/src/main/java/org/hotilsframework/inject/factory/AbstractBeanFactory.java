package org.hotilsframework.inject.factory;

import org.hotilsframework.collect.TypeMap;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.Scopes;
import org.hotilsframework.inject.factory.config.*;
import org.hotilsframework.lang.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * AbstractBeanFactory
 *
 * 抽象Bean工厂
 *
 * @author hireny
 * @create 2020-08-09 23:03
 */
public abstract class AbstractBeanFactory implements BeanFactory, ScopeRegistry {

    private final TypeMap<Scoping> scopes = TypeMap.create();

    protected AbstractBeanFactory() {
        initScopes(null);
    }

    protected AbstractBeanFactory(Scoping... scopes) {
        this(Arrays.asList(scopes));
    }

    protected AbstractBeanFactory(List<Scoping> scopes) {
        initScopes(scopes);
    }

    /**
     * 作用域初始化
     */
    void initScopes(List<Scoping> scopes) {

        // 初始化
        addScopes();

        if (scopes != null) {
            // 添加自定义的作用域
            addScopes(scopes);
        }
    }

    /**
     * 添加的初始化作用域
     */
    void addScopes() {
        registerScope(Singletons.class, new Singletons());
        registerScope(Prototypes.class, new Prototypes());
    }

    /**
     * 添加的额外的作用域
     * @param scopes
     */
    void addScopes(List<Scoping> scopes) {
        Assert.notNull(scopes, "scope objects is not null.");
        for (Scoping scope : scopes) {
            if (Scopes.getScopeClasses().contains(scope.getClass())) {
                continue;
            }
            registerScope(scope.getClass(), scope);
        }
    }

    @Override
    public <T> T get(Key<T> key, Class<?> scopeType) {
        Scoping scope = this.scopes.get(scopeType);
        return scope.get(key);
    }

    @Override
    public void registerScope(Class<? extends Scoping> type, Scoping scope) {
        Assert.notNull(type, "scope type is not null.");
        Assert.notNull(scope, "scope object is not null.");
        Scoping old = this.scopes.get(type);
        if (old != null) {
            throw new IllegalStateException("Could not register object [" + scope + "] under key '" + type + "': there is already object [" + old + "] bound");
        }
        this.scopes.put(type, scope);
    }

    @Override
    public Scoping getScope(Class<? extends Scoping> type) {
        return getScopes().get(type);
    }

    @Override
    public boolean containsScope(Class<? extends Scoping> type) {
        return getScopes().containsKey(type);
    }

    /**
     * 获取作用域对象
     * @return
     */
    public TypeMap<Scoping> getScopes() {
        return this.scopes;
    }
}
