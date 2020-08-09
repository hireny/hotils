package org.hotilsframework.inject.factory.config;

/**
 * ScopeRegistry
 *
 * 作用域注册
 *
 * @author hireny
 * @create 2020-08-10 0:12
 */
public interface ScopeRegistry {
    /**
     * 注册作用域
     * @param type
     * @param scope
     */
    void registerScope(final Class<? extends Scope> type, final Scope scope);

    /**
     * 获取作用域
     * @param type
     * @return
     */
    Scope getScope(final Class<? extends Scope> type);

    /**
     * 作用域是否存在
     * @param type
     * @return
     */
    boolean containsScope(final Class<? extends Scope> type);
}
