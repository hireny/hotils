package org.hotilsframework.io;

import org.hotilsframework.utils.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

/**
 * @ClassName: Charsets
 * @Description: TODO   编码工具类
 * @Author: hireny
 * @Date: Created in 2020-01-08 8:27
 * @Version: 1.0
 */
public final class Charsets {
    /**
     * ISO-8859-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /**
     * UTF-8
     */
    public static final String UTF_8 = "UTF-8";
    /**
     * GBK
     */
    public static final String GBK = "GBK";
    /**
     * ISO-8859-1
     */
    public static final Charset CHARSET_ISO_8859_1 = StandardCharsets.ISO_8859_1;
    /**
     * UTF-8
     */
    public static final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;

    public static final Charset CHARSET_GBK = Charset.forName(GBK);

    /**
     * 转换为Charset对象
     * @param charsetName   字符集，为空则返回默认字符集
     * @return              Charset
     * @throws UnsupportedCharsetException  编码不支持
     */
    public static Charset forName(String charsetName) throws UnsupportedCharsetException {
        return StringUtils.isBlank(charsetName) ? Charset.defaultCharset() : Charset.forName(charsetName);
    }
}
