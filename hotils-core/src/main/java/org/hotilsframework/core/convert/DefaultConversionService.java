package org.hotilsframework.core.convert;

import org.hotilsframework.core.convert.converter.ConverterRegistry;
import org.hotilsframework.core.convert.converter.support.StringToBooleanConverter;
import org.hotilsframework.core.convert.converter.support.StringToCharacterConverter;
import org.hotilsframework.core.convert.converter.support.StringToCharsetConverter;
import org.hotilsframework.core.convert.converter.support.StringToUUIDConverter;

/**
 * 默认的转换服务
 * @author hireny
 * @className DefaultConversionService
 * @create 2020-07-04 9:33
 */
public class DefaultConversionService extends GenericConversionService {

    /**
     * 默认转换服务的构造器
     *
     * 使用该构造器的时候，会添加一个新的默认服务添加到构造器中
     */
    public DefaultConversionService() {
    }

    /**
     * 添加默认转换器
     * @param converterRegistry
     */
    static void addDefaultConverters(ConverterRegistry converterRegistry) {
        addScalerConverters(converterRegistry);
    }

    /**
     * 添加标量的转换器
     * @param converterRegistry
     */
    private static void addScalerConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverter(new StringToCharsetConverter());
        converterRegistry.addConverter(new StringToCharacterConverter());
        converterRegistry.addConverter(new StringToBooleanConverter());
        converterRegistry.addConverter(new StringToUUIDConverter());
    }
}
