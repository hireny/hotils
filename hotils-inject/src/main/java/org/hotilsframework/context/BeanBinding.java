package org.hotilsframework.context;

import org.hotilsframework.inject.BeanDefinition;

import java.util.Objects;

/**
 * BeanBinding
 *
 * Bean的绑定关系
 *
 * @author hireny
 * @create 2020-08-11 23:58
 */
public class BeanBinding<T> {

    final BeanDefinition beanDefinition;
    final T bean;

    public BeanBinding(BeanDefinition beanDefinition, T bean) {
        this.beanDefinition = beanDefinition;
        this.bean = bean;
    }

    public BeanDefinition getBeanDefinition() {
        return beanDefinition;
    }

    public T getBean() {
        return bean;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BeanBinding{");
        sb.append(beanDefinition).append("=");
        sb.append(bean);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BeanBinding<?> that = (BeanBinding<?>) o;
        return Objects.equals(beanDefinition, that.beanDefinition) &&
                Objects.equals(bean, that.bean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanDefinition, bean);
    }
}
