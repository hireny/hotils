package me.hireny.commons.core.io;

import me.hireny.commons.core.lang.Strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

/**
 * @ClassName: Charsets
 * @Author: hireny
 * @Date: Create in 2019/12/12 21:59
 * @Description: TODO   字符集编码常量
 */
public interface Charsets {

    /**
     * ISO-8859-1
     */
    String ISO_8859_1 = "ISO-8859-1";
    /**
     * UTF-8
     */
    String UTF_8 = "UTF-8";
    /**
     * GBK
     */
    String GBK = "GBK";
    /**
     * ISO-8859-1
     */
    Charset CHARSET_ISO_8859_1 = StandardCharsets.ISO_8859_1;
    /**
     * UTF-8
     */
    Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;

    Charset CHARSET_GBK = Charset.forName(GBK);

    /**
     * 转换为Charset对象
     * @param charsetName   字符集，为空则返回默认字符集
     * @return              Charset
     * @throws UnsupportedCharsetException  编码不支持
     */
    static Charset forName(String charsetName) throws UnsupportedCharsetException {
        return Strings.isBlank(charsetName) ? Charset.defaultCharset() : Charset.forName(charsetName);
    }
}
