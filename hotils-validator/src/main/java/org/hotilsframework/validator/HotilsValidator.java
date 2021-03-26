package org.hotilsframework.validator;

import jakarta.validation.Configuration;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.spi.BootstrapState;
import jakarta.validation.spi.ConfigurationState;
import jakarta.validation.spi.ValidationProvider;

/**
 * HotilsValidator
 *
 * 验证器
 *
 * @author hireny
 * @create 2020-11-30 13:45
 */
public class HotilsValidator implements ValidationProvider {
    @Override
    public Configuration createSpecializedConfiguration(BootstrapState bootstrapState) {
        return null;
    }

    @Override
    public Configuration<?> createGenericConfiguration(BootstrapState bootstrapState) {
        return null;
    }

    @Override
    public ValidatorFactory buildValidatorFactory(ConfigurationState configurationState) {
        return null;
    }
}
