package org.hotilsframework.inject.support;

import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.factory.config.Scoping;
import org.hotilsframework.inject.Scopes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

/**
 * AbstractBeanDefinition
 * 类描述
 *
 * @author hireny
 * @create 2020-08-06 18:05
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {
    private static final long serialVersionUID = -388034840993663377L;
    /**
     * 父关系的BeanDefinition
     */
    private BeanDefinition parent;
    /**
     * 类型
     */
    private final Class<?> type;
    /**
     * 名称
     */
    private final String  name;
    /**
     * 作用域
     */
    private final Scoping scoping;
    /**
     * 是否被实例化
     */
    private final boolean isAbstract;
    /**
     * 懒加载
     */
    private final boolean lazyInit;

    public AbstractBeanDefinition(
            BeanDefinition parent,
            Class<?> type,
            String name,
            Scoping scoping,
            boolean lazyInit) {
        this.parent = parent;
        this.type = type;
        this.name = name;
        this.scoping = scoping;
        this.isAbstract = Modifier.isAbstract(this.type.getModifiers());
        this.lazyInit = lazyInit;
    }

    @Override
    public BeanDefinition getParent() {
        return this.parent;
    }

    @Override
    public Class<?> getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isSingleton() {
        return Scopes.SINGLETON.equals(this.scoping);
    }

    @Override
    public boolean isPrototype() {
        return Scopes.PROTOTYPE.equals(this.scoping);
    }

    @Override
    public boolean isAbstract() {
        return this.isAbstract;
    }

    @Override
    public boolean islazyInit() {
        return this.lazyInit;
    }

    @Override
    public Class<? extends Annotation> getScoping() {
        return this.scoping.getScopeAnnotation();
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public int length() {
        return getName().length();
    }

    @Override
    public char charAt(int index) {
        return getName().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return getName().subSequence(start, end);
    }
}
