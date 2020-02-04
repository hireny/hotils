package org.hotilsframework.beans;

import org.hotilsframework.collection.Maps;

import java.util.Map;

/**
 * BeanMap对象
 * @ClassName: BeanMap
 * @Author: hireny
 * @Date: Created in 2020-01-29 16:26
 * @Version: 1.0
 */
public class BeanMap {

    private final Object bean;

    private final Map map;

    public static BeanMap create(Object bean) {
        return new BeanMap(bean);
    }

    public static BeanMap create(Map map) {
        return new BeanMap(map);
    }


    private BeanMap(Object bean) {
        this(bean, Maps.newHashMap());
    }

    private BeanMap(Map map) {
        this(null, map);
    }

    private BeanMap(Object bean, Map map) {
        this.bean = bean;
        this.map = map;
    }

    public Object getBean() {
        return this.bean;
    }

    public Map getMap() {
        return this.map;
    }

    /**
     * 对象转Map
     * @param bean      Bean对象
     * @param target    目标的Map
     */
    public void beanToMap(Object bean, Map target) {

    }

    /**
     * Map转Bean属性拷贝
     * @param source        Map对象
     * @param target        目标Bean对象
     */
    public void mapToBean(Map source, Object target) {

    }
}
