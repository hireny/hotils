package org.hotilsframework.convert.converter.support;

import org.hotilsframework.convert.converter.Converter;

import java.nio.charset.Charset;

/**
 * @ClassName: StringToCharsetConverter
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:41
 * @Description: TODO   将字符串转换为字符集
 */
public class StringToCharsetConverter implements Converter<String, Charset> {
    @Override
    public Charset convert(String source) {
        return Charset.forName(source);
    }
}
