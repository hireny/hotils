package org.hotilsframework.core.core.convert.converter;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.core.convert.converter.support.StringToBooleanConverter;
import org.hotilsframework.core.convert.converter.support.StringToCharacterConverter;
import org.hotilsframework.core.convert.converter.support.StringToCharsetConverter;
import org.hotilsframework.core.convert.converter.support.StringToUUIDConverter;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @ClassName: ConverterTest
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:58
 * @Description: TODO   转换器测试
 */
public class ConverterTest {

    /**
     * 字符串转换为布尔类型的测试
     */
    @Test
    public void stringToBooleanTest() {
        String a = "true";
        String b = "false";
        String c = "on";
        String d = "yes";
        String e = "1";
        String f = "off";
        String g = "no";
        String h = "0";

        Converter<String, Boolean> stringBooleanConverter = new StringToBooleanConverter();
        Boolean aConverter = stringBooleanConverter.convert(a);
        Boolean bConverter = stringBooleanConverter.convert(b);
        Boolean cConverter = stringBooleanConverter.convert(c);
        Boolean dConverter = stringBooleanConverter.convert(d);
        Boolean eConverter = stringBooleanConverter.convert(e);
        Boolean fConverter = stringBooleanConverter.convert(f);
        Boolean gConverter = stringBooleanConverter.convert(g);
        Boolean hConverter = stringBooleanConverter.convert(h);

        System.out.println(a + "(" + a.getClass()  + ") -> " + aConverter + "(" + aConverter.getClass() + ")");
        System.out.println(b + "(" + b.getClass()  + ") -> " + bConverter + "(" + bConverter.getClass() + ")");
        System.out.println(c + "(" + c.getClass()  + ") -> " + cConverter + "(" + cConverter.getClass() + ")");
        System.out.println(d + "(" + d.getClass()  + ") -> " + dConverter + "(" + dConverter.getClass() + ")");
        System.out.println(e + "(" + e.getClass()  + ") -> " + eConverter + "(" + eConverter.getClass() + ")");
        System.out.println(f + "(" + f.getClass()  + ") -> " + fConverter + "(" + fConverter.getClass() + ")");
        System.out.println(g + "(" + g.getClass()  + ") -> " + gConverter + "(" + gConverter.getClass() + ")");
        System.out.println(h + "(" + h.getClass()  + ") -> " + hConverter + "(" + hConverter.getClass() + ")");
    }

    /**
     * 字符串转字符测试
     */
    @Test
    public void stringToCharacterTest() {
        String str = "就";
        Converter<String, Character> stringCharacterConverter = new StringToCharacterConverter();
        Character a = null;
        try {
            a = stringCharacterConverter.convert(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a);
    }

    /**
     * 字符串转换为字符集
     */
    @Test
    public void stringToCharsetTest() {
        String str = "utf-8";
        Converter<String, Charset> stringCharacterConverter = new StringToCharsetConverter();
        Charset a = null;
        try {
            a = stringCharacterConverter.convert(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a);
    }

    @Test
    public void stringToUUIDTest() {
        String str = "fdfjoewifowf";
        Converter<String, UUID> stringCharacterConverter = new StringToUUIDConverter();
        UUID a = null;
        try {
            a = stringCharacterConverter.convert(str);
        } catch (Exception e) {
            System.out.println("错误信息="+e.getMessage());
        }
        System.out.println(str + "(" + str.getClass() + ") -> " + a + "(" + a.getClass() + ")");
    }
}
