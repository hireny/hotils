package org.hotilsframework.http;

import org.hotilsframework.core.net.http.RequestMethod;

/**
 * @ClassName: HttpTemplate
 * @Author: hireny
 * @Date: Create in 2019/12/10 01:52
 * @Description: TODO   HTTP客户端请求模板
 */
public final class HttpTemplate {

    private HttpTemplate() {}

    /**
     * 检测是否是https
     * @param url   URL
     * @return      是否是https
     */
    public static boolean isHttps(String url) {
        return url.toLowerCase().startsWith("https");
    }

    /**
     * 创建Http请求对象
     *
     * @param url       请求的URL，可以使用HTTP或者HTTPS
     * @param method    方法枚举 {@link RequestMethod}
     * @return  {@link HttpRequest}
     */
    public static HttpRequest createRequest(String url, RequestMethod method) {
        return new HttpRequest(url).method(method);
    }

    /**
     * 创建 Http GET 请求对象
     *
     * @param url   请求的URL，可以使用HTTP或者HTTPS
     * @return      {@link RequestMethod}
     */
    public static HttpRequest createGetRequest(String url) {
        return createRequest(url, RequestMethod.GET);
    }

    /**
     * 创建 Http POST 请求对象
     * @param url   请求的URL，可以使用HTTP或者HTTPS
     * @return      {@link RequestMethod}
     */
    public static HttpRequest createPostRequest(String url) {
        return createRequest(url, RequestMethod.POST);
    }
}
