package org.hotilsframework.web;

import org.hotilsframework.lang.StringUtils;

/**
 * @ClassName: HtmlUtils
 * @Author: hireny
 * @Date: Create in 2020/01/06 11:12
 * @Description: TODO   HTML工具类
 */
public class HtmlUtils {
    /**
     * HTML字符转义
     *
     * <p>
     * * @return String 过滤后的字符串
     * * @see 对输入参数中的敏感字符进行过滤替换，防止用户利用JavaScript等方式石蕊恶意代码
     * </p>
     * @param input
     * @return
     */
    public static String htmlEscape(String input) {
        if (StringUtils.isEmpty(input)) {
            return input;
        }
        input = input.replaceAll("&", "&amp;");
        input = input.replaceAll("<", "&lt;");
        input = input.replaceAll(">", "&gt;");
        input = input.replaceAll(" ", "&nbsp;");

        // IE暂不支持单引号的实体名称，而支持单引号的实体编号，故单引号转义成实体编号，其它字符转义成实体名称
        input = input.replaceAll("'", "&#39;");

        // 双引号也需要转义，所以加一个斜线对其进行转义
        input = input.replaceAll("\"", "&quot;");

        // 不能把 \n 的过滤放在前面，因为还要对 < 和 > 过滤，这样就会导致 <br/> 失效了
        input = input.replaceAll("\n", "<br/>");

        return input;
    }

    /**
     * 获取URL的 一级，二级，三级域名
     * @param url
     * @param level     域名等级
     * @return
     */
    public static String getDomainName(String url, Integer level) {
        return null;
    }
}
