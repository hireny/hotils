package org.hotilsframework.core.convert.converter.support;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.lang.StringUtils;

/**
 * @ClassName: StringToCharacterConverter
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:43
 * @Description: TODO   将字符串转换为字符类型
 */
public class StringToCharacterConverter implements Converter<String, Character> {
    @Override
    public Character convert(String source) {

        if (StringUtils.isEmpty(source)) {
            return null;
        }
        if (source.length() > 1) {
            // 只能将长度为1的字符串转换为字符
            throw new IllegalArgumentException(
                    "Can only convert a [String] with length of 1 to a [Character]; string value '" + source + "'  has length of " + source.length());
        }

        return source.charAt(0);
    }
}
