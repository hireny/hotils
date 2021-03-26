package org.hotilsframework.core.escape;

/**
 * Escape
 *
 * 忽略
 *
 * @author hireny
 * @create 2020-11-08 18:44
 */
public interface Escaper {
    /**
     * 返回一个给定的忽略的字符串
     * @param string
     * @return
     */
    String escape(String string);
}
