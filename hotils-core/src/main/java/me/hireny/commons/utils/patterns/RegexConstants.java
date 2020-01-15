package me.hireny.commons.utils.patterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/06 00:12
 * @Description：TODO    正则
 */
public interface RegexConstants {

    // 用户正则常量
    // 用户名正则,6到16位(字母、数字、下划线、字母开头)
    String USERNAME_REGEX = "^[A-Za-z][A-Za-z_0-9]{5,17}$";
    // 手机号码
    String PHONE_NUMBER_REGEX = "^1\\d{10}$";
    // 邮箱正则 ("www."可省略不写)
    String EMAIL_REGEX = "^(www\\.)?\\w+(\\.\\w+)*@\\w+(\\.\\w+)+$";


    // 全网IP
    String IP_REGEX = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$";
    // 汉字 (个数限制为一个或多个)
    String CHINESE_REGEX = "^[\u4e00-\u9f5a]+$";
    // 身份证号
    String ID_CARD = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";
    // 网址
    String URL = "^(([hH][tT]{2}[pP][sS]?)|([fF][tT][pP]))://[\\w.-]+\\.\\w{2,4}((/.*)?|(\\?.+))$";
    // 汉字
    String CHAR_CN = "^[\\u4e00-\\u9fa5]+$";


    /**
     * 手机号
     */
    Pattern MOBILE = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

    /**
     * 汉字
     */
    Pattern CHINESE = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 邮政编码
     */
    Pattern POSTALCODE = Pattern.compile("[1-9]\\d{5}(?!\\d)");

    /**
     * 邮箱
     */
    Pattern EMAIL =
            Pattern.compile("^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$");

    /**
     * IP地址
     */
    Pattern IP = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)");



    List<Pattern> FILTER_PATTERNS = Collections.unmodifiableList(Arrays.asList(

            // Avoid common html tags
            Pattern.compile("(<input(.*?)></input>|<input(.*)/>)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<span(.*?)</span>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<div(.*)</div>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<style>(.*?)</style>", Pattern.CASE_INSENSITIVE),
            //Avoid onload= expressions
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // Avoid anything between script tags
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            // Avoid javascript:... expressions
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // Remove any lonesome </script> tag
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // Avoid anything in a src='...' type of expression
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // Avoid eval(...) expressions
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // Avoid vbscript:... expressions
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE)

    ));
}
