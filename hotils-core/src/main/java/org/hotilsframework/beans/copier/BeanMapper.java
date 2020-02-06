package org.hotilsframework.beans.copier;

import org.hotilsframework.beans.CopyOptions;

/**
 * @ClassName: BeanMapper
 * @Author: hireny
 * @Date: Created in 2020-02-05 23:56
 * @Version: 1.0
 */
public class BeanMapper<S, T> {

    private Class<S> sourceClass;
    private Class<T> targetClass;
    private CopyOptions options;
}
