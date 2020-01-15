package me.hireny.commons.core.convert.converter.support;

import me.hireny.commons.core.convert.converter.Converter;
import me.hireny.commons.utils.StringUtils;

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
        return StringUtils.hasLength(source) ? UUID.fromString(source.trim()) : null;
    }
}
