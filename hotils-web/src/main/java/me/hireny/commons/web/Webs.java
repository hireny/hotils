package me.hireny.commons.web;

import me.hireny.commons.core.lang.Strings;
import me.hireny.commons.core.lang.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: Webs
 * @Author: hireny
 * @Date: Create in 2019/12/10 00:03
 * @Description: TODO   Web工具类
 */
public class Webs {
    private static final Logger logger = LoggerFactory.getLogger(Webs.class);

    private Webs() {}

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
     * 获取 IP地址
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
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (Strings.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
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
}
