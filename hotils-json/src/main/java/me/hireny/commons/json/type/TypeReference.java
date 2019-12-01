package me.hireny.commons.json.type;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/12 12:36
 * @Description: TODO   引用类型
 */
public class TypeReference<T> {

    private final Type type;
    private volatile Constructor<?> constructor;


    protected TypeReference() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
    }


    /**
     * Instantiates a new instance of {@code T} using the default, no-arg constructor
     * 使用默认的无参构造函数实例化一个新的 {@code T} 实例
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @SuppressWarnings("unchecked")
    public T newInstance()
            throws NoSuchMethodException, IllegalAccessException,
                   InvocationTargetException, InstantiationException {
        if (constructor == null) {
            Class<?> rawType = type instanceof Class<?>
                    ? (Class<?>) type
                    : (Class<?>) ((ParameterizedType) type).getRawType();
            constructor = rawType.getConstructor();
        }
        return (T) constructor.newInstance();
    }

    public Type getType() {
        return this.type;
    }

    public static void main(String[] args) throws Exception {
        List<String> l1 = new TypeReference<ArrayList<String>>() {}.newInstance();
        List l2 = new TypeReference<ArrayList>() {}.newInstance();
    }
}
