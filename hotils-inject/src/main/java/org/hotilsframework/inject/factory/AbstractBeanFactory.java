package org.hotilsframework.inject.factory;

import org.hotilsframework.cache.TypeCache;
import org.hotilsframework.collect.Sets;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.Prototype;
import org.hotilsframework.inject.factory.config.Prototypes;
import org.hotilsframework.inject.factory.config.Scope;
import org.hotilsframework.inject.factory.config.ScopeRegistry;
import org.hotilsframework.inject.factory.config.Singletons;
import org.hotilsframework.utils.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * AbstractBeanFactory
 *
 * 抽象Bean工厂
 *
 * @author hireny
 * @create 2020-08-09 23:03
 */
public abstract class AbstractBeanFactory implements BeanFactory, ScopeRegistry {

    private final TypeCache<Scope> scopes = TypeCache.create();

    protected AbstractBeanFactory() {
        initScopes(null);
    }

    protected AbstractBeanFactory(Scope... scopes) {
        initScopes(Sets.newHashSet(scopes));
    }

    protected AbstractBeanFactory(Set<Scope> scopes) {
        initScopes(scopes);
    }

    /**
     * 作用域初始化
     */
    void initScopes(Set<Scope> scopes) {
        // 当scopes为空时
        if (scopes == null || scopes.isEmpty()) {
            addScopes();
        } else {
            addScopes(scopes);
        }
    }

    void addScopes() {
        registerScope(Singletons.class, new Singletons());
        registerScope(Prototypes.class, new Prototypes());
    }

    void addScopes(Set<Scope> scopes) {
        Assert.notNull(scopes, "scope objects is not null.");
        for (Scope scope : scopes) {
            registerScope(scope.getClass(), scope);
        }
    }

    @Override
    public Object getBean(Key<?> key, Class<?> scopeType) {
        Scope scope = this.scopes.get(scopeType);
        return scope.get(key, null);
    }

    @Override
    public void registerScope(Class<? extends Scope> type, Scope scope) {
        Assert.notNull(type, "scope type is not null.");
        Assert.notNull(scope, "scope object is not null.");
        Scope old = this.scopes.get(type);
        if (old != null) {
            throw new IllegalStateException("Could not register object [" + scope + "] under key '" + type + "': there is already object [" + old + "] bound");
        }
        this.scopes.put(type, scope);
    }

    @Override
    public Scope getScope(Class<? extends Scope> type) {
        return getScopes().get(type);
    }

    @Override
    public boolean containsScope(Class<? extends Scope> type) {
        return getScopes().containsKey(type);
    }

    /**
     * 获取作用域对象
     * @return
     */
    public TypeCache<Scope> getScopes() {
        return this.scopes;
    }
}
