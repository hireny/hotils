package org.hotilsframework.core.text;

/**
 * 格式化类型T的对象
 *
 * 一个即是 Printer ，又是 Parser 的对象类型的格式化接口
 * @ClassName: Formatter
 * @Author: hireny
 * @Date: Created in 2020-02-08 14:37
 * @Version: 1.0
 */
public interface Formatter<T> extends Printer<T>, Parser<T> {
}
