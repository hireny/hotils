package org.hotilsframework.inject.factory.config;

import org.hotilsframework.lang.reflects.TypeInstance;
import org.hotilsframework.inject.BeanKey;
import org.hotilsframework.inject.annotation.Prototype;

import java.lang.annotation.Annotation;

/**
 * Prototypes
 *
 * 原型作用域的对象获取类
 *
 * @author hireny
 * @create 2020-08-09 23:36
 */
public class Prototypes extends AbstractScoping implements Scoping {
    @Override
    public void register(BeanKey<?> beanKey, Object element) {
    }

    @Override
    public <T> T get(BeanKey<T> beanKey) {
        return TypeInstance.tryInstance(beanKey.getType());
    }
    @Override
    public Object remove(BeanKey<?> beanKey) {
        return null;
    }
    @Override
    public boolean containsKey(BeanKey<?> beanKey) {
        return false;
    }
    @Override
    public Class<? extends Annotation> getScopeAnnotation() {
        return Prototype.class;
    }
}
