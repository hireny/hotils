package me.hireny.commons.utils;

/**
 * @ClassName: EscapeEL
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:47
 * @Description: TODO
 */
public class EscapeEL {
    /**
     * EL wrapper for {@link Escape#html(String)}
     */
    public static String htmlEscape(String input) {
        return Escape.html(input);
    }

    /**
     * EL wrapper for {@link Escape#htmlText(String)}, equivalent to <code>fn:escapeXml</code>.
     */
    public static String htmlText(String input) {
        return Escape.htmlText(input);
    }

    /**
     * EL wrapper for {@link Escape#uriParam(String)}
     */
    public static String uriParamEncode(String input) {
        return Escape.uriParam(input);
    }

    /**
     * EL wrapper for {@link Escape#uri(String)}
     */
    public static String uriEncode(String input) {
        return Escape.uri(input);
    }

    /**
     * EL wrapper for {@link Escape#jsString(String)}
     */
    public static String jsStringEscape(String input) {
        return Escape.jsString(input);
    }

    /**
     * EL wrapper for {@link Escape#jsRegex(String)}
     */
    public static String jsRegexEscape(String input) {
        return Escape.jsRegex(input);
    }

    /**
     * EL wrapper for {@link Escape#cssString(String)}
     */
    public static String cssStringEscape(String input) {
        return Escape.cssString(input);
    }
}
