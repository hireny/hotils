package org.hotilsframework.beans;

import org.hotilsframework.collect.Maps;
import org.hotilsframework.lang.reflects.TypeInstance;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * BeanMap对象
 * @className BeanMap
 * @author hireny
 * @date Created in 2020-01-29 16:26
 * @version 1.0
 */
public class BeanMap {

    private final Object bean;

    private final Map<?, ?> map;

    public static BeanMap create(Object source) {
        return new BeanMap(source);
    }

    public static BeanMap create(Map<?,?> source, Object target) {
        return new BeanMap(source, target);
    }

    public static BeanMap create(Map<?, ?> source, Class<?> clazz) {
        return new BeanMap(source, clazz);
    }

    private BeanMap(Object bean) {
        this.bean = bean;
        this.map = Maps.newHashMap();
        beanToMap(bean, map);
    }

    private BeanMap(Map<?, ?> source, Object target) {
        this.map = source;
        this.bean = target;
        mapToBean(source, target);
    }

    private BeanMap(Map<?, ?> source, Class<?> clazz) {
        this.map = source;
        this.bean = TypeInstance.tryInstance(clazz);
        mapToBean(source, bean);
    }

    public Object toBean() {
        return this.bean;
    }

    public Map<?,?> toMap() {
        return this.map;
    }

    public Set<?> keySets() {
        return this.map.keySet();
    }

    public Set<? extends Map.Entry<?, ?>> entrySets() {
        return this.map.entrySet();
    }

    public Collection<?> values() {
        return this.map.values();
    }

    /**
     * 对象转Map
     * @param source        Bean对象
     * @param target        Map对象
     */
    private void beanToMap(Object source, Map<?, ?> target) {
        BeanUtils.beanToMap(source, (Map<String, Object>) target);
    }

    private void mapToBean(Map<?, ?> source, Object target) {
        BeanUtils.mapToBean(source, target);
    }
}
