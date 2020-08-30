package org.hotilsframework.io;

import org.hotilsframework.lang.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

/**
 * 字符集工具集
 * @className Charsets
 * @author hireny
 * @date Created in 2020-01-08 8:27
 * @version 1.0
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

    public static final String US_ASCII = "US-ASCII";
    /**
     * ISO-8859-1
     */
    public static final Charset CHARSET_ISO_8859_1 = StandardCharsets.ISO_8859_1;
    /**
     * UTF-8
     */
    public static final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;
    /**
     * GBK
     */
    public static final Charset CHARSET_GBK = Charsets.forName(GBK);

    public static final Charset CHARSET_US_ASCII = Charsets.forName(US_ASCII);

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
