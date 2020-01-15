package me.hireny.commons.core.lang;

import me.hireny.commons.utils.Assert;

import java.util.*;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:36
 * @Description: TODO   对象工具类，包括判空、克隆、序列化等操作
 */
public final class Objects<T> implements Wrapper<T> {

    private T target;
    private Class<T> targetClass;

    public static <T> Objects of(T t) {
        return new Objects(t);
    }

    private Objects(T o) {
        this.target = o;
        this.targetClass = (Class<T>) o.getClass();
    }


    @Override
    public <T> T getTarget() {
        return (T) this.target;
    }

    @Override
    public <T> Class<T> getTargetClass() {
        return (Class<T>) this.targetClass;
    }
}
