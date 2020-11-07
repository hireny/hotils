package org.hotilsframework.inject;

import org.hotilsframework.inject.annotation.Prototype;
import org.hotilsframework.inject.annotation.Singleton;

import java.lang.annotation.Annotation;

/**
 * Scope
 *
 * 作用域
 *
 * @author hireny
 * @create 2020-09-10 23:58
 */
public interface Scope {
    /**
     * 获取作用域
     * @return  返回作用域
     */
    Scope getScope();

    /**
     * 获取作用域注解
     * @return
     */
    Class<? extends Annotation> getScopeAnnotation();

    /**
     * 返回字符串
     * @return
     */
    @Override
    String toString();

    /**
     * 传入作用域注解，返回作用域
     * @param scopeType
     * @return
     */
    static Scope forAnnotation(final Class<? extends Annotation> scopeType) {
        if (scopeType == Singleton.class || scopeType == javax.inject.Singleton.class) {
            // 单例作用域
            return Scopes.SINGLETON;
        }
        if (scopeType == Prototype.class) {
            // 原型作用域
            return Scopes.PROTOTYPE;
        }
        return new Scope() {
            @Override
            public Scope getScope() {
                return this;
            }
            @Override
            public Class<? extends Annotation> getScopeAnnotation() {
                return scopeType;
            }
        };
    }
}
