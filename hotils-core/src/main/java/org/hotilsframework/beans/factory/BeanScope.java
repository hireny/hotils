package org.hotilsframework.beans.factory;

/**
 * @author hireny
 * @className BeanScope
 * @create 2020-04-08 13:08
 */
public enum BeanScope {
    SINGLETON("singleton"),
    PROTOTYPE("prototype");

    String value;

    BeanScope(String value) {
        this.value = value;
    }

    /**
     * 获取值
     * @return
     */
    public String getValue() {
        return value;
    }
}
