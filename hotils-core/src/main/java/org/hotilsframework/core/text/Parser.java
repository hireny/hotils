package org.hotilsframework.core.text;

import java.text.ParseException;
import java.util.Locale;

/**
 * @ClassName: Parser
 * @Author: hireny
 * @Date: Created in 2020-02-08 14:34
 * @Version: 1.0
 */
@FunctionalInterface
public interface Parser<T> {

    /**
     * 解析文本字符串以生成 T类型的对象
     * @param text
     * @param locale
     * @return
     * @throws ParseException
     */
    T parse(String text, Locale locale) throws ParseException;
}
