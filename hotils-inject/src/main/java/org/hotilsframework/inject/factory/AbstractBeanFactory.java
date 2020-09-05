package org.hotilsframework.inject.factory;

import org.hotilsframework.cache.TypeCache;
import org.hotilsframework.inject.Key;
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

    private final TypeCache<Scope> scopes = TypeCache.create();

    protected AbstractBeanFactory() {
        initScopes(null);
    }

    protected AbstractBeanFactory(Scope... scopes) {
        this(Arrays.asList(scopes));
    }

    protected AbstractBeanFactory(List<Scope> scopes) {
        initScopes(scopes);
    }

    /**
     * 作用域初始化
     */
    void initScopes(List<Scope> scopes) {

        // 初始化
        addScopes();

        if (scopes != null) {
            // 添加自定义的作用域
            addScopes(scopes);
        }
    }

    void addScopes() {
        registerScope(Singletons.class, new Singletons());
        registerScope(Prototypes.class, new Prototypes());
    }

    void addScopes(List<Scope> scopes) {
        Assert.notNull(scopes, "scope objects is not null.");
        for (Scope scope : scopes) {
            if (Scopes.getScopeClasses().contains(scope.getClass())) {
                continue;
            }
            registerScope(scope.getClass(), scope);
        }
    }

    @Override
    public <T> T get(Key<T> key, Class<?> scopeType) {
        Scope scope = this.scopes.get(scopeType);
        return scope.get(key);
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
