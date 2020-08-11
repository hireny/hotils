package org.hotilsframework.http;

import java.net.URI;

/**
 * HttpRequest
 *
 * HTTP请求
 *
 * @author hireny
 * @date Create in 2019/12/10 01:55
 */
public interface HttpRequest extends HttpMessage {

    default HttpMethod getMethod() {
        return HttpMethod.resolve(getMethodValue());
    }

    /**
     * 获取该请求方法的值，例如：GET/POST 等
     * @return
     */
    String getMethodValue();


    URI getURI();
}
