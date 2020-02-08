package org.hotilsframework.core.text;

import java.util.Locale;

/**
 * 打印机
 * @ClassName: Printer
 * @Author: hireny
 * @Date: Created in 2020-02-08 13:31
 * @Version: 1.0
 */
@FunctionalInterface
public interface Printer<T> {

    /**
     * 打印类型为 T 的对象进行显示
     * @param object
     * @param locale
     * @return
     */
    String print(T object, Locale locale);
}
