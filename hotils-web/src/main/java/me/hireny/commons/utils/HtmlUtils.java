package me.hireny.commons.utils;

import me.hireny.commons.core.lang.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: HtmlUtils
 * @Author: hireny
 * @Date: Create in 2020/01/06 11:12
 * @Description: TODO   HTML工具类
 */
public class HtmlUtils {
    /**
     * 逃避
     * @param s
     * @return
     */
    public static String escape(String s) {
        // 过滤html标签
        String htmlStr = s; //含html标签的字符串
        String textStr = "";
        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;
        Pattern p_cont1;
        Matcher m_cont1;
        Pattern p_cont2;
        Matcher m_cont2;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String regEx_cont1 = "[\\d+\\s*`~!@#$%^&*\\(?~！@#￥%……&*（）——+|{}【】‘：”“’_]"; // 定义HTML标签的正则表达式
            String regEx_cont2 = "[\\w[^\\W]*]"; // 定义HTML标签的正则表达式[a-zA-Z]
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            p_cont1 = Pattern.compile(regEx_cont1, Pattern.CASE_INSENSITIVE);
            m_cont1 = p_cont1.matcher(htmlStr);
            htmlStr = m_cont1.replaceAll(""); // 过滤其它标签
            p_cont2 = Pattern.compile(regEx_cont2, Pattern.CASE_INSENSITIVE);
            m_cont2 = p_cont2.matcher(htmlStr);
            htmlStr = m_cont2.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr; //返回文本字符串
    }

    /**
     * 根据正则过滤内容
     * @param html
     * @param pattern
     * @return
     */
    public static String htmlEscape(String html, Pattern pattern) {
        Matcher matcher = pattern.matcher(html);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString().trim();
    }

    public static String htmlEscape(String html) {
        if (!Strings.isBlank(html)) {
            Pattern pattern = Pattern.compile("<([^>]*)>");
            return htmlEscape(html, pattern);
        }
        return null;
    }

    /**
     * 过滤指定html标签
     * @param html
     * @param tag
     * @return
     */
    public static String htmlEscape(String html, String tag) {
        if (!Strings.isBlank(html)) {
            if (Strings.isBlank(tag)) {
                Pattern pattern = Pattern.compile("<([^>]*)>");
                return htmlEscape(html, pattern);
            } else {
                Pattern pattern = Pattern.compile("<\\s*(/?)\\s*" + tag + "\\s*([^>]*)\\s*>");
                return htmlEscape(html, pattern);
            }
        }
        return null;
    }
}
