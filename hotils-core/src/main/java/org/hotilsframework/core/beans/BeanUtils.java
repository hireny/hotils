package org.hotilsframework.core.beans;

import org.hotilsframework.core.beans.copier.BeanCopier;
import org.hotilsframework.core.beans.copier.CopyOptions;
import org.hotilsframework.core.collection.CaseInsensitiveMap;
import org.hotilsframework.core.lang.Filter;
import org.hotilsframework.utils.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName: BeanUtils
 * @Author: hireny
 * @Date: Create in 2019/12/09 01:25
 * @Description: TODO   Bean工具类
 */
public final class BeanUtils {

    private BeanUtils() {}

    //****************BeanInfo PropertyDescriptors********************//

    /**
     * 获得Bean字段描述数组
     * @param clazz             Bean类
     * @return                  字段描述数组
     * @throws BeansException   获取属性异常
     */
    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz)
            throws BeansException {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            return propertyDescriptors;
        } catch (IntrospectionException e) {
            throw new BeansException(e);
        }
    }

    /**
     * 获得字段名和字段描述Map，获得的结果会缓存
     * @param clazz         Bean类
     * @param ignoreCase    是否忽略大小写
     * @return
     */
    public static Map<String, PropertyDescriptor> getPropertyDescriptors(Class<?> clazz, boolean ignoreCase) throws BeansException {
        final PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(clazz);
        final Map<String, PropertyDescriptor> propertyDescriptorMap = ignoreCase ? new CaseInsensitiveMap<>(propertyDescriptors.length, 1)
                : new HashMap<>(propertyDescriptors.length, 1);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            propertyDescriptorMap.put(propertyDescriptor.getName(), propertyDescriptor);
        }
        return propertyDescriptorMap;
    }

    /**
     * 获得Bean类属性描述
     * @param clazz             Bean类
     * @param propertyName      属性名
     * @return                  PropertyDescriptor
     * @throws BeansException   Bean异常
     */
    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName)
            throws BeansException {
        final PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(clazz);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if (propertyName.equals(propertyDescriptor.getName())) {
                return propertyDescriptor;
            }
        }
        return null;
    }

    /**
     * 对目标对象中指定的属性名设置值
     * @param target            目标对象
     * @param propertyName      属性名
     * @param value             属性值
     */
    public static void setPropertyValue(Object target, String propertyName, Object value) throws BeansException {
        // 获取对象的类型
        Class<?> clazz = target.getClass();
        // 获取clazz类型中propertyName的属性描述器
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(clazz, propertyName);
        // 从属性描述器中获取 set 方法
        Method setter = propertyDescriptor.getWriteMethod();
        try {
            // 调用 set 方法将传入的 value 值保存到属性中去
            setter.invoke(target, new Object[]{value});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new BeansException(e);
        }
    }

    /**
     * 根据属性名以及对象获取对应的属性值
     * @param target        目标对象
     * @param propertyName  属性名
     * @return              属性值
     */
    public static Object getPropertyValue(Object target, String propertyName) throws BeansException {
        // 获取对象的类型
        Class<?> clazz = target.getClass();
        // 获取 clazz 类型中 propertyName 的属性描述器
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(clazz, propertyName);
        // 从属性描述其中获取 get 方法
        Method getter = propertyDescriptor.getReadMethod();
        Object value = null;
        try {
            // 调用方法获取方法的返回值
            value = getter.invoke(clazz);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new BeansException(e);
        }
        // 返回值
        return value;
    }


    //****************Bean copyProperties********************//

    /**
     * 复制Bean对象属性
     * @param source    源Bean对象
     * @param target    目标Bean对象
     */
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, CopyOptions.create());
    }

    /**
     * 复制Bean对象属性
     * 限制类用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类
     *
     * @param source                源Bean对象
     * @param target                目标Bean对象
     * @param ignoreProperties      不拷贝的属性列表
     */
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        copyProperties(source, target, target.getClass(), ignoreProperties);
    }

    /**
     * 复制Bean对象属性
     * 限制类用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类
     *
     * @param source            源Bean对象
     * @param target            目标Bean对象
     * @param editable          编辑的类
     * @param ignoreProperties       忽略的配置
     */
    public static void copyProperties(Object source, Object target, Class<?> editable, String... ignoreProperties) {
        copyProperties(source, target, CopyOptions.create(editable, ignoreProperties));
    }

    /**
     * 复制Bean对象属性
     * @param source        源对象
     * @param target        目标对象
     * @param options       拷贝选项 {@link CopyOptions}
     */
    public static void copyProperties(Object source, Object target, CopyOptions options) {
        if (null == options) {
            options = CopyOptions.create();
        }
        BeanCopier.create(source, target, options).copy();
    }

    //===========================================================================
    // Java Bean 与 Map 转换
    //===========================================================================

    /**
     * Java Bean转换为Map
     * @param source    待转换的Java Bean
     * @param target    转换后的Map关系映射
     */
    public static void beanToMap(Object source, Map<String, Object> target) {
        Assert.notNull(source, "bean is not null.");
        Assert.notNull(target, "map is not null.");

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                // 过滤class属性
                if (!"class".equals(key)) {
                    // 得到propertyDescriptor对应的getter方法
                    Method getterMethod = propertyDescriptor.getReadMethod();
                    getterMethod.setAccessible(true);
                    Object value = getterMethod.invoke(source);

                    target.put(key, value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Map转换为Java Bean
     * @param source       待转换的Map
     * @param target     转换的目标类
     * @return          转换后的Java Bean对象
     */
    public static void mapToBean(Map<?, ?> source, Object target) {
        Assert.notNull(source, "bean is not null.");
        Assert.notNull(target, "map is not null.");

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (Objects.isNull(target)) {
                target = ReflectionUtils.newInstance(target.getClass());
            }
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                if (source.containsKey(key)) {
                    Object value = source.get(key);
                    // 得到propertyDescriptor对应的setter方法
                    Method setterMethod = propertyDescriptor.getWriteMethod();
                    setterMethod.invoke(target, value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
