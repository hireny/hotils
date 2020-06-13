package org.hotilsframework.web;

import org.hotilsframework.lang.Splitter;

import java.util.List;

/**
 * @ClassName: WebSecurityUtils
 * @Author: hireny
 * @Date: Create in 2019/12/03 14:26
 * @Description: TODO   WEB安全工具类
 */
public class WebSecurityUtils {

    private WebSecurityUtils() {}

    /**
     * 处理XSS
     * @param values
     * @return
     */
    public static String[] xssStrip(String[] values) {
        if (null == values) {
            return null;
        }
        String[] newValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = xssStrip(values[i]);
        }
        return newValues;
    }

    /**
     * 处理XSS
     * @param value
     * @return
     */
    private static String xssStrip(String value) {
        return null;
    }


    /**
     * SQL注入风险监测
     */
    private static List<String> SQL_KEY_WORDS = Splitter.on(",").splitToList("'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|; |or|-|+|,");
    /**
     * 是否是SQL注入
     * @param params
     * @return
     */
    public static boolean isSqlInject(String... params) {
        if (null == params) {
            return false;
        }
        for (String param : params) {
            for (int i = 0, len = SQL_KEY_WORDS.size(); i < len; i++) {
                if (param.toLowerCase().contains(" " + SQL_KEY_WORDS.get(i) + "")) {
                    return true;
                }
            }
        }
        return false;
    }
}
