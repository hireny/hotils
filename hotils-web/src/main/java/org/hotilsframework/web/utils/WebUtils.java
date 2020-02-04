package org.hotilsframework.web.utils;

import org.hotilsframework.collection.Maps;
import org.hotilsframework.lang.Symbol;
import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @ClassName: WebUtils
 * @Author: hireny
 * @Date: Create in 2020/01/06 11:13
 * @Description: TODO   Web工具类
 */
public class WebUtils {
    private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);

    private WebUtils() {}


    /**
     * 获取指定Cookie的值
     * @param request
     * @param cookieName    cookie名字
     * @param defaultValue  缺省值
     * @return
     */
    public static final String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        if (cookie == null) {
            return defaultValue;
        }
        return cookie.getValue();
    }

    /**
     * 获取指定的Cookie
     * @param request
     * @param cookName  cooki名字
     * @return
     */
    public static final Cookie getCookie(HttpServletRequest request, String cookName) {
        Assert.checkNotNull(request, "Request must not be null.");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            int length = cookies.length;
            for (int i = 0; i < length; i++) {
                Cookie cookie = cookies[i];
                if (cookName.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 将一些数据放到Session中，以便于其他地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     *
     * @param request
     * @param key
     * @param value
     */
    public static final void setSession(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        if (null != session) {
            session.setAttribute(key, value);
        }
    }

    /**
     * 直接用HttpSession.getAttribute(key)取
     * @param request
     * @param key
     * @return
     */
    public static Object getSession(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        if (null != null) {
            return session.getAttribute(key);
        }
        return null;
    }

    /**
     * 获取国际化信息
     * @param request
     * @param key       键
     * @return
     */
    public static final String getApplicationResource(HttpServletRequest request, String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources", request.getLocale());
        return resourceBundle.getString(key);
    }

    public static Map<String, Object> getRequestParam(String param) {
        Map<String, Object> paramMap = Maps.newLinkedHashMap();
        if (null != param) {
            String[] params = param.split("&");
            for (String s : params) {
                String[] p = s.split("=");
                if (p.length == 2) {
                    paramMap.put(p[0], p[1]);
                }
            }
        }
        return paramMap;
    }


    private static final String UNKNOWN = "unknown";
    private static final String X_FORWARDED_FOR = "X-Forwarded-For";
    private static final String X_REAL_IP = "X-Real-IP";
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    private static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
    private static final String LOCALHOST_IP = "127.0.0.1";
    private static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
    private static final int MAX_IP_LENGTH = 15;

    /**
     * IP地址请求头
     */
    private static final String[] IP_HEADERS = {
            "X-Real-IP",
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR"
    };

    /**
     * 获取客户端 IP地址
     * 使用 Nginx等反向代理软件， 则不能通过 request.getRemoteAddr()获取 IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，
     * X-Forwarded-For中第一个非 unknown的有效IP字符串，则为真实IP地址
     */
    /**
     * 获取用户远程地址
     * @param request
     * @return
     */
    public static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCALHOST_IP.equals(ip) || LOCALHOST_IP_16.equals(ip)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    logger.error("获取IP地址, 出现异常={}", e.getMessage(), e);
                }
                assert inet != null;
                ip = inet.getHostAddress();
            }
            logger.info("获取IP地址 ip={}", ip);
        }
        // 对于通过多个代理的情况, 第一个IP为客户端真实IP,多个IP按照','分割 //"***.***.***.***".length() = 15
        if (ip != null && ip.length() > MAX_IP_LENGTH) {
            if (ip.indexOf(Symbol.COMMA) > 0) {
                ip = ip.substring(0, ip.indexOf(Symbol.COMMA));
            }
        }
        return ip;
    }

    /**
     * 尝试获取当前请求的HttpServletRequest实例中的参数
     * @param request
     * @return
     */
    public static Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> parameters = new HashMap<>();
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = String.valueOf(enumeration.nextElement());
            parameters.put(name, request.getParameter(name));
        }
        return parameters;
    }

    /**
     * 尝试获取当前请求的HttpServletRequest实例中的请求头
     * @param request
     * @return
     */
    public static Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    public static String getDomain(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String getOrigin(HttpServletRequest request){
        return request.getHeader("Origin");
    }

    /**
     * 判断是否为AJAX请求
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }

    /**
     * 判断是否是白名单
     * @param url
     * @param size
     * @param whiteUrls
     * @return
     */
    public static boolean isWhiteRequest(String url, int size, List<String> whiteUrls) {
        if (url == null || "".equals(url) || size == 0) {
            return true;
        }
        url = url.toLowerCase();
        for (String temp : whiteUrls) {
            if (url.indexOf(temp.toLowerCase()) > -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean write(ServletResponse response, Integer code, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> modelMap = Maps.newLinkedHashMap();
        modelMap.put("code", code.toString());
        modelMap.put("msg", msg);
        modelMap.put("timestamp", System.currentTimeMillis());
        response.getOutputStream().write(modelMap.toString().getBytes());
        return false;
    }
}
