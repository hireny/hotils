package org.hotilsframework.web.servlet;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: XssRequestWrapper
 * @Author: hireny
 * @Date: Create in 2019/12/03 13:29
 * @Description: TODO   XSS自定义RequestWrapper用于解决XSS攻击
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 过滤FORM表单数据
     * @param name
     * @return
     */
    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }

    /**
     * 过滤FORM表单数据
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        return super.getParameter(name);
    }

    /**
     * 过滤Header
     * @param name
     * @return
     */
    @Override
    public String getHeader(String name) {
        return super.getHeader(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return super.getInputStream();
    }
}
