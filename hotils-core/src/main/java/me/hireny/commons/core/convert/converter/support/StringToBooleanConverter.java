package me.hireny.commons.core.convert.converter.support;

import me.hireny.commons.core.convert.converter.Converter;
import me.hireny.commons.core.lang.Strings;
import org.omg.CORBA.portable.ValueBase;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: StringToBooleanConverter
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:46
 * @Description: TODO   将字符串转换为布尔类型
 */
public class StringToBooleanConverter implements Converter<String, Boolean> {

    private static final Set<String> trueValues = new HashSet<>();
    private static final Set<String> falseValues = new HashSet<>();

    static {
        trueValues.add("true");
        trueValues.add("on");
        trueValues.add("yes");
        trueValues.add("1");

        falseValues.add("false");
        falseValues.add("off");
        falseValues.add("no");
        falseValues.add("0");
    }

    @Override
    public Boolean convert(String source) {
        if (Strings.isBlank(source)) {
            return null;
        }
        source = source.toLowerCase();
        if (trueValues.contains(source)) {
            return Boolean.TRUE;
        } else if (falseValues.contains(source)) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
    }
}
