package org.hotilsframework.design;

import java.io.Serializable;

/**
 * @ClassName: Builder
 * @Author: hireny
 * @Date: Create in 2019/12/07 01:30
 * @Description: TODO   建造者模式接口定义
 */
public interface Builder<T> extends Serializable {

    /**
     * 构建
     * @return  被构建的对象
     */
    T build();
}
