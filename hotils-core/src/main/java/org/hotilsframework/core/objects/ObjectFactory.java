package org.hotilsframework.core.objects;

/**
 * @ClassName: ObjectFactory
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:05
 * @Description: TODO   对象工厂的基本接口
 * TODO 作为对象池的参数传入，提供生成一个对象的方法
 */
public interface ObjectFactory<T> {
    /**
     * 对象创建
     * @return
     */
    T create();
}
