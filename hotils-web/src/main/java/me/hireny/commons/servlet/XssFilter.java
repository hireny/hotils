package me.hireny.commons.servlet;

import me.hireny.commons.core.lang.Strings;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: XssFilter
 * @Author: hireny
 * @Date: Create in 2019/12/03 13:28
 * @Description: TODO   XSS跨站脚本过滤器
 */
public class XssFilter implements Filter {

    /**
     * 需要排除的页面
     */
    private String excludedPages;

    /**
     * 需要排除的页面数组
     */
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取不拦截的地址
        excludedPages = filterConfig.getInitParameter("excludedPages");
        if (!Strings.isEmpty(excludedPages)) {
            excludedPageArray = excludedPages.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 获取访问路径
        String requestUrl = req.getRequestURI();
        boolean isExcludedPage = false;
        for (String excludedPage : excludedPageArray) {
            // 判断是否在过滤URL之外
            if (requestUrl.contains(excludedPage)) {
                isExcludedPage = true;
                break;
            }
        }
        // 额外页不进行XSS过滤
        if (isExcludedPage) {
            chain.doFilter(request, response);
            return;
        }
        // pass the request a long the filter chain
        XssRequestWrapper xssRequestWrapper = new XssRequestWrapper(req);
        // 设置cookie为HTTPOnly，防止JS获取cookie
        res.setHeader("Set-Cookie", "cookiename=value; Path=/;Domain=domainvalue;Max-Age=seconds;HTTPOnly");
        chain.doFilter(xssRequestWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
