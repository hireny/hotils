package org.hotilsframework.http;

import org.hotilsframework.collect.CollectionUtils;
import org.hotilsframework.collect.LinkedCaseInsensitiveMap;
import org.hotilsframework.collect.MultiValueMap;
import org.hotilsframework.lang.Assert;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: HttpHeaders
 * @Author: hireny
 * @Date: Create in 2019/11/08 23:14
 * @Description: TODO       对HTTP协议进行封装
 */
public class HttpHeaders implements MultiValueMap<String, String>, Serializable {

    private static final long serialVersionUID = 8893307436341566358L;

    // HTTP Request and Response header fields
    // HTTP请求和响应头字段

    /** The HTTP {@code Cache-Control} header field name. */
    public static final String CACHE_CONTROL = "Cache-Control";
    /** The HTTP {@code Content-Length} header field name. */
    public static final String CONTENT_LENGTH = "Content-Length";
    /** The HTTP {@code Content-Type} header field name. */
    public static final String CONTENT_TYPE = "Content-Type";
    /** The HTTP {@code Date} header field name. */
    public static final String DATE = "Date";
    /** The HTTP {@code Pragma} header field name. */
    public static final String PRAGMA = "Pragma";
    /** The HTTP {@code Via} header field name. */
    public static final String VIA = "Via";
    /** The HTTP {@code Warning} header field name. */
    public static final String WARNING = "Warning";

    // HTTP Request header fields
    // HTTP 请求头字段

    /**
     * 告诉WEB服务器自己接受什么介质类型，
     * /*表示任何类型，
     * type/*表示该类型下的所有子类型，
     * type/sub-type
     */
    public static final String ACCEPT = "Accept";
    /** 浏览器申明自己接收的字符集 */
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    /** 浏览器申明自己接收的编码方法，通常指定压缩方法，是否支持压缩，支持什么压缩方法(gzip,deflate) */
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    /** 浏览器申明自己接收的语言(语言跟字符集的区别：中文是语言，中文有多种字符集，比如big5，gb2312，gbk等等) */
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    /** The HTTP {@code Access-Control-Request-Headers} header field name. */
    public static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
    /** The HTTP {@code Access-Control-Request-Method} header field name. */
    public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
    /** The HTTP {@code Authorization} header field name. */
    public static final String AUTHORIZATION = "Authorization";
    /** The HTTP {@code Connection} header field name. */
    public static final String CONNECTION = "Connection";
    /** The HTTP {@code Cookie} header field name. */
    public static final String COOKIE = "Cookie";
    /**
     * The HTTP <a href="https://fetch.spec.whatwg.org/#cross-origin-resource-policy-header">{@code
     * Cross-Origin-Resource-Policy}</a> header field name.
     *
     * @since 28.0
     */
    public static final String CROSS_ORIGIN_RESOURCE_POLICY = "Cross-Origin-Resource-Policy";
    /**
     * The HTTP <a href="https://tools.ietf.org/html/rfc8470">{@code Early-Data}</a> header field
     * name.
     *
     * @since 27.0
     */
    public static final String EARLY_DATA = "Early-Data";
    /** The HTTP {@code Expect} header field name. */
    public static final String EXPECT = "Expect";
    /** The HTTP {@code From} header field name. */
    public static final String FROM = "From";
    /**
     * The HTTP <a href="https://tools.ietf.org/html/rfc7239">{@code Forwarded}</a> header field name.
     *
     * @since 20.0
     */
    public static final String FORWARDED = "Forwarded";
    /**
     * The HTTP {@code Follow-Only-When-Prerender-Shown} header field name.
     *
     * @since 17.0
     */
    public static final String FOLLOW_ONLY_WHEN_PRERENDER_SHOWN = "Follow-Only-When-Prerender-Shown";
    /** The HTTP {@code Host} header field name. */
    public static final String HOST = "Host";
    /**
     * The HTTP <a href="https://tools.ietf.org/html/rfc7540#section-3.2.1">{@code HTTP2-Settings}
     * </a> header field name.
     *
     * @since 24.0
     */
    public static final String HTTP2_SETTINGS = "HTTP2-Settings";
    /** The HTTP {@code If-Match} header field name. */
    public static final String IF_MATCH = "If-Match";
    /** The HTTP {@code If-Modified-Since} header field name. */
    public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    /** The HTTP {@code If-None-Match} header field name. */
    public static final String IF_NONE_MATCH = "If-None-Match";
    /** The HTTP {@code If-Range} header field name. */
    public static final String IF_RANGE = "If-Range";
    /** The HTTP {@code If-Unmodified-Since} header field name. */
    public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
    /** The HTTP {@code Last-Event-ID} header field name. */
    public static final String LAST_EVENT_ID = "Last-Event-ID";
    /** The HTTP {@code Max-Forwards} header field name. */
    public static final String MAX_FORWARDS = "Max-Forwards";
    /** The HTTP {@code Origin} header field name. */
    public static final String ORIGIN = "Origin";
    /** The HTTP {@code Proxy-Authorization} header field name. */
    public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
    /** The HTTP {@code Range} header field name. */
    public static final String RANGE = "Range";
    /** The HTTP {@code Referer} header field name. */
    public static final String REFERER = "Referer";
    /**
     * The HTTP <a href="https://www.w3.org/TR/referrer-policy/">{@code Referrer-Policy}</a> header
     * field name.
     *
     * @since 23.4
     */
    public static final String REFERRER_POLICY = "Referrer-Policy";

    final MultiValueMap<String, String> headers;

    public HttpHeaders(MultiValueMap<String, String> headers) {
        Assert.notNull(headers, "MultiValueMap must not be null.");
        this.headers = headers;
    }

    @Override
    public String getFirst(String key) {
        return null;
    }

    @Override
    public void add(String key, String value) {

    }

    @Override
    public void addAll(String key, List<? extends String> values) {

    }

    @Override
    public void addAll(MultiValueMap<String, String> values) {

    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void setAll(Map<String, String> values) {

    }

    @Override
    public Map<String, String> toSingleValueMap() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public List<String> get(Object key) {
        return null;
    }

    @Override
    public List<String> put(String key, List<String> value) {
        return null;
    }

    @Override
    public List<String> remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<String>> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<List<String>> values() {
        return null;
    }

    @Override
    public Set<Entry<String, List<String>>> entrySet() {
        return null;
    }
}
