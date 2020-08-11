package org.hotilsframework.inject.support;

import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.factory.config.Scope;

import java.util.Vector;

/**
 * BeanDefinitionBuilder
 *
 * Bean定义构建器
 *
 * @author hireny
 * @create 2020-08-06 17:49
 */
public class BeanDefinitionBuilder {
    /**
     * 用于 {@code BeanDefinition} 的实例化创建
     */
//    private final AbstractBeanDefinition beanDefinition;

    /**
     * 父关系的BeanDefinition
     */
    private       BeanDefinition parent;
    /**
     * 类型
     */
    private Class<?> type;
    /**
     * 名称
     */
    private String   name;
    /**
     * 作用域
     */
    private Scope    scope;
    /**
     * 懒加载
     */
    private       boolean lazyInit;

    private BeanDefinitionBuilder() {}

//    private BeanDefinitionBuilder(AbstractBeanDefinition beanDefinition) {
//        this.beanDefinition = beanDefinition;
//    }
//
//
//    BeanDefinitionBuilder beanDefinition(AbstractBeanDefinition beanDefinition) {
//        this.beanDefinition = beanDefinition;
//    }

    BeanDefinitionBuilder parent(BeanDefinition parent) {
        this.parent = parent;
        return this;
    }

    BeanDefinitionBuilder type(Class<?> type) {
        this.type = type;
        return this;
    }

    BeanDefinitionBuilder name(String name) {
        this.name = name;
        return this;
    }

    BeanDefinitionBuilder scope(Scope scope) {
        this.scope = scope;
        return this;
    }

    BeanDefinitionBuilder lazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
        return this;
    }

    /**
     * 构建BeanDefinition
     * @return
     */
    BeanDefinition build() {
        // 构建抽象BeanDefinition
        if (parent == null) {
            parent = new RootBeanDefinition();
        }
        BeanDefinition beanDefinition =
                new ConstructBeanDefinition(this.parent, this.type, this.type.getName(), this.scope, this.lazyInit);

        return beanDefinition;

    }


    private static class RootBeanDefinition extends AbstractBeanDefinition {

        public RootBeanDefinition() {
            super(null, null, null, null, false);
        }
    }
}
