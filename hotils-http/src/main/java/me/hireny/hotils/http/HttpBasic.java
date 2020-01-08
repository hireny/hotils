package me.hireny.hotils.http;

import me.hireny.commons.core.collect.CaseInsensitiveMap;
import me.hireny.commons.core.collect.Collections;
import me.hireny.commons.core.io.Charsets;
import me.hireny.commons.core.io.Resource;
import me.hireny.commons.core.lang.Strings;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.hireny.commons.core.net.NetConstants.HTTP_1_1;

/**
 * @ClassName: HttpBasic
 * @Author: hireny
 * @Date: Create in 2019/12/10 02:00
 * @Description: TODO   Http请求的基类
 *
 * @param <T> 子类类型，方便链式编程
 */
public abstract class HttpBasic<T> {

    /**存储头信息*/
    protected Map<String, List<String>> headers = new HashMap<>();
    /**编码*/
    protected Charset charset = Charsets.CHARSET_UTF_8;
    /**http版本*/
    protected String httpVersion = HTTP_1_1;
    /**存储主体*/
    protected byte[] bodyBytes;

    /**
     * 根据name获取头信息
     *
     * 根据 RFC2616规范，header的name不区分大小写
     *
     * @param name  Header名
     * @return      Header值
     */
    public String header(String name) {
        final List<String> values = headers(name);
        if (Collections.isEmpty(values)) {
            return null;
        }
        return values.get(0);
    }

    /**
     * 根据name获取头信息列表
     *
     * @param name  Header名
     * @return      Header值
     */
    public List<String> headers(String name) {
        if (Strings.isBlank(name)) {
            return null;
        }
        final CaseInsensitiveMap<String, List<String>> headersIgnoreCase = new CaseInsensitiveMap<>(this.headers);
        return headersIgnoreCase.get(name.trim());
    }

    /**
     * 设置一个header
     * 如果覆盖模式，则替换之前的值，否则加入到值列表中
     * @param name          Header名
     * @param value         Header值
     * @param isOverride    是否覆盖已有值
     * @return              本身
     */
    public T header(String name, String value, boolean isOverride) {
        return null;
    }
}
