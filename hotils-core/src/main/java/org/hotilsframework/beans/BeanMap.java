package org.hotilsframework.beans;

import org.hotilsframework.collection.Maps;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    private final Map<String, Object> map;

    public static BeanMap create(Object source) {
        return new BeanMap(source);
    }

    public static BeanMap create(Map<String, Object> source, Class<?> clazz) {
        return new BeanMap(source, clazz);
    }

    private BeanMap(Object bean) {
        this.bean = bean;
        this.map = beanToMap(this.bean);
    }

    private BeanMap(Map<String, Object> map, Class<?> clazz) {
        this.map = map;
        this.bean = mapToBean(map, clazz);
    }

    public Object getBean() {
        return this.bean;
    }

    public Map<String, Object> getMap() {
        return this.map;
    }

    public Set<String> keySets() {
        return this.map.keySet();
    }

    public Set<Map.Entry<String, Object>> entrySets() {
        return this.map.entrySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    /**
     * 对象转Map
     * @param source      Bean对象
     */
    private Map<String, Object> beanToMap(Object source) {
        return BeanUtils.beanToMap(source);
    }

    /**
     * Map转Bean属性拷贝
     * @param source        Map对象
     * @param clazz         目标类
     */
    private Object mapToBean(Map<String, Object> source, Class<?> clazz) {
        return BeanUtils.mapToBean(source, clazz);
    }
}
