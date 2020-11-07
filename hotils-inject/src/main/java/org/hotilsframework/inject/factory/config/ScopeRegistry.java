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
     * @param scoping
     */
    void registerScope(final Class<? extends Scoping> type, final Scoping scoping);

    /**
     * 获取作用域
     * @param type
     * @return
     */
    Scoping getScope(final Class<? extends Scoping> type);

    /**
     * 作用域是否存在
     * @param type
     * @return
     */
    boolean containsScope(final Class<? extends Scoping> type);
}
