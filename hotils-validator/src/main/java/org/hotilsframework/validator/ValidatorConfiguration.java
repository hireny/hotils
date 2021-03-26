package org.hotilsframework.validator;

import jakarta.validation.Configuration;

/**
 * ValidatorConfiguration
 *
 * 验证器配置
 *
 * @author hireny
 * @create 2020-11-30 13:55
 */
public interface ValidatorConfiguration<S extends ValidatorConfiguration<S>> extends Configuration<S> {
}
