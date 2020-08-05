package org.hotilsframework.inject;

import org.hotilsframework.beans.BeansException;

/**
 * BeanElement
 *
 * 用于描述绑定信息的Bean元素集合
 *
 * @author hireny
 * @create 2020-08-02 9:41
 */
public interface BeanElements {

    BeanElements EMPTY = new BeanElements() {
        @Override
        public Object getElement(Key<?> key) throws BeansException {
            throw new AssertionError();
        }

        @Override
        public <T> Provider<T> getProvider(Key<T> key) {
            throw new AssertionError();
        }
    };

    /**
     * 获取Bean
     * @param key       键
     * @return          获取Bean对象
     */
    Object getElement(Key<?> key) throws BeansException;

    /**
     * 根据
     * @param key
     * @param <T>
     * @return
     */
    <T> Provider<T> getProvider(Key<T> key);

}
