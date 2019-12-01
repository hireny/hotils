package me.hireny.commons.core.utils.regex;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/06 00:12
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
}
