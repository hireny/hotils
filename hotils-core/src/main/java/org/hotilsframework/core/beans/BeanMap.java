package org.hotilsframework.core.beans;

import java.util.*;

/**
 * BeanMap对象
 * @ClassName: BeanMap
 * @Author: hireny
 * @Date: Created in 2020-01-29 16:26
 * @Version: 1.0
 */
public class BeanMap {

    private final Object bean;

    private final Map<?, ?> map;

    public static BeanMap create(Object source) {
        return new BeanMap(source);
    }

    public static BeanMap create(Map<?, ?> source, Class<?> clazz) {
        return new BeanMap(source, clazz);
    }

    private BeanMap(Object bean) {
        this.bean = bean;
        this.map = beanToMap(this.bean);
    }

    private BeanMap(Map<?, ?> map, Class<?> clazz) {
        this.map = map;
        this.bean = mapToBean(map, clazz);
    }

    public Object getBean() {
        return this.bean;
    }

    public Map getMap() {
        return this.map;
    }

    public Set keySets() {
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
     * @param source      Bean对象
     */
    private Map<?, ?> beanToMap(Object source) {
        return BeanUtils.beanToMap(source);
    }

    /**
     * Map转Bean属性拷贝
     * @param source        Map对象
     * @param clazz         目标类
     */
    private Object mapToBean(Map<?, ?> source, Class<?> clazz) {
        return BeanUtils.mapToBean(source, clazz);
    }
}
