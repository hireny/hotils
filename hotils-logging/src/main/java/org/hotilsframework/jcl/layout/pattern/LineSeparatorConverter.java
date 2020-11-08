package org.hotilsframework.jcl.layout.pattern;

import org.hotilsframework.jcl.LoggingEvent;

/**
 * 行分隔符转换
 * @author hireny
 * @className LineSeparatorConverter
 * @create 2020-02-18 21:11
 */
public class LineSeparatorConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent source) {
        return "\n";
    }

    public static void main(String[] args) {
        System.out.print("\n");
    }
}