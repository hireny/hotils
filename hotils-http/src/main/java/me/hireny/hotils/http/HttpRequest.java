package me.hireny.hotils.http;

import me.hireny.commons.core.net.http.RequestMethod;
import me.hireny.commons.utils.Assert;

import java.net.URLStreamHandler;

/**
 * @ClassName: HttpRequest
 * @Author: hireny
 * @Date: Create in 2019/12/10 01:55
 * @Description: TODO   Http请求
 */
public class HttpRequest extends HttpBasic<HttpRequest> {

    /**
     * url地址
     */
    private String url;
    /**
     * URL流处理
     */
    private URLStreamHandler urlStreamHandler;
    /**
     * 请求方法     默认GET请求
     */
    private RequestMethod method = RequestMethod.GET;
    /**
     * 默认连接超时
     */
    private int connectionTimeout = - 1;

    /**
     * 构造
     *
     * @param url   URL
     */
    public HttpRequest(String url) {
        Assert.checkNotNull(url, "Param [url] can not be null!");
        this.url = url;
        // 给定一个默认头信息
//        this.header(DefaultHeaders.INSTANCE);
    }

    /**
     * 方法
     * @return
     */
    public HttpRequest method(RequestMethod method) {
        this.method = method;
        return this;
    }
}
