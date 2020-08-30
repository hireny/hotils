package org.hotilsframework.core.convert.converter.support;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.lang.StringUtils;

import java.util.UUID;

/**
 * @ClassName: StringToUUIDConverter
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:51
 * @Description: TODO   字符串转换为UUID
 */
public class StringToUUIDConverter implements Converter<String, UUID> {
    @Override
    public UUID convert(String source) {
        return StringUtils.isBlank(source) ?  null : UUID.fromString(source.trim());
    }
}
