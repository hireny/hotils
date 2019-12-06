package me.hireny.commons.utils;

/**
 * @ClassName: Escape
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:28
 * @Description: TODO   忽略工具类
 */
public class Escape {

    private Escape() {}

    public static String html(String input) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            switch (c) {
                // Control chars
                case '\t':
                    output.append("&#x09;");
                    break;
                case '\n':
                    output.append("&#x0A;");
                    break;
                case '\f':
                    output.append("&#x0C;");
                    break;
                case '\r':
                    output.append("&#x0D;");
                    break;
                // Chars that have a meaning for HTML
                case '\'':
                    output.append("&#39;");
                    break;
                case '\\':
                    output.append("&#x5C;");
                    break;
                case ' ':
                    output.append("&#x20;");
                    break;
                case '/':
                    output.append("&#x2F;");
                    break;
                case '"':
                    output.append("&quot;");
                    break;
                case '<':
                    output.append("&lt;");
                    break;
                case '>':
                    output.append("&gt;");
                    break;
                case '&':
                    output.append("&amp;");
                    break;
                // Unicode new lines
                case '\u2028':
                    output.append("&#x2028;");
                    break;
                case '\u2029':
                    output.append("&#x2029;");
                    break;

                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }

    public static String htmlText(String input) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            switch (c) {
                case '\'':
                    output.append("&#39;");
                    break;
                case '"':
                    output.append("&quot;");
                    break;
                case '<':
                    output.append("&lt;");
                    break;
                case '>':
                    output.append("&gt;");
                    break;
                case '&':
                    output.append("&amp;");
                    break;
                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }

    public static String uriParam(String input) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            switch (c) {
                // Control chars
                case '\t':
                    output.append("%09");
                    break;
                case '\n':
                    output.append("%0A");
                    break;
                case '\f':
                    output.append("%0C");
                    break;
                case '\r':
                    output.append("%0D");
                    break;
                // RFC chars to encode, plus % ' " < and >, and space
                case ' ':
                    output.append("%20");
                    break;
                case '!':
                    output.append("%21");
                    break;
                case '"':
                    output.append("%22");
                    break;
                case '#':
                    output.append("%23");
                    break;
                case '$':
                    output.append("%24");
                    break;
                case '%':
                    output.append("%25");
                    break;
                case '&':
                    output.append("%26");
                    break;
                case '\'':
                    output.append("%27");
                    break;
                case '(':
                    output.append("%28");
                    break;
                case ')':
                    output.append("%29");
                    break;
                case '*':
                    output.append("%2A");
                    break;
                case '+':
                    output.append("%2B");
                    break;
                case ',':
                    output.append("%2C");
                    break;
                case '.':
                    output.append("%2E");
                    break;
                case '/':
                    output.append("%2F");
                    break;
                case ':':
                    output.append("%3A");
                    break;
                case ';':
                    output.append("%3B");
                    break;
                case '<':
                    output.append("%3C");
                    break;
                case '=':
                    output.append("%3D");
                    break;
                case '>':
                    output.append("%3E");
                    break;
                case '?':
                    output.append("%3F");
                    break;
                case '@':
                    output.append("%40");
                    break;
                case '[':
                    output.append("%5B");
                    break;
                case ']':
                    output.append("%5D");
                    break;

                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }

    public static String uri(String input) {
        return uriParam(input);
    }

    public static String jsString(String input) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            switch (c) {
                // Control chars
                case '\b':
                    output.append("\\u0008");
                    break;
                case '\t':
                    output.append("\\u0009");
                    break;
                case '\n':
                    output.append("\\u000A");
                    break;
                case '\u000b':
                    output.append("\\u000B");
                    break;
                case '\f':
                    output.append("\\u000C");
                    break;
                case '\r':
                    output.append("\\u000D");
                    break;
                // JavaScript String chars
                case '\'':
                    output.append("\\u0027");
                    break;
                case '"':
                    output.append("\\u0022");
                    break;
                case '\\':
                    output.append("\\u005C");
                    break;
                // URI encoding char
                case '%':
                    output.append("\\u0025");
                    break;
                // HTML chars for closing the parent context
                case '&':
                    output.append("\\u0026");
                    break;
                case '/':
                    output.append("\\u002F");
                    break;
                case '<':
                    output.append("\\u003C");
                    break;
                case '>':
                    output.append("\\u003E");
                    break;
                // Unicode
                case '\u2028':
                    output.append("\\u2028");
                    break;
                case '\u2029':
                    output.append("\\u2029");
                    break;

                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }

    public static String jsRegex(String input) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            switch (c) {
                // Control chars
                case '\t':
                    output.append("\\t");
                    break;
                case '\n':
                    output.append("\\n");
                    break;
                case '\u000b':
                    output.append("\\v");
                    break;
                case '\f':
                    output.append("\\f");
                    break;
                case '\r':
                    output.append("\\r");
                    break;
                // Escape sequence, and regexp terminator
                case '\\':
                    output.append("\\\\");
                    break;
                case '/':
                    output.append("\\/");
                    break;
                // Regexp specific characters
                case '(':
                    output.append("\\(");
                    break;
                case '[':
                    output.append("\\[");
                    break;
                case '{':
                    output.append("\\{");
                    break;
                case ']':
                    output.append("\\]");
                    break;
                case ')':
                    output.append("\\)");
                    break;
                case '}':
                    output.append("\\}");
                    break;
                case '*':
                    output.append("\\*");
                    break;
                case '+':
                    output.append("\\+");
                    break;
                case '-':
                    output.append("\\-");
                    break;
                case '.':
                    output.append("\\.");
                    break;
                case '?':
                    output.append("\\?");
                    break;
                case '!':
                    output.append("\\!");
                    break;
                case '^':
                    output.append("\\^");
                    break;
                case '$':
                    output.append("\\$");
                    break;
                case '|':
                    output.append("\\|");
                    break;
                // Unicode
                case '\u2028':
                    output.append("\\u2028");
                    break;
                case '\u2029':
                    output.append("\\u2029");
                    break;
                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }

    public static String cssString(String input) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            switch (c) {
                // Control chars
                case '\b':
                    output.append("\\08 ");
                    break;
                case '\t':
                    output.append("\\09 ");
                    break;
                case '\n':
                    output.append("\\0A ");
                    break;
                case '\f':
                    output.append("\\0C ");
                    break;
                case '\r':
                    output.append("\\0D ");
                    break;
                // String chars
                case '\'':
                    output.append("\\27 ");
                    break;
                case '"':
                    output.append("\\22 ");
                    break;
                case '\\':
                    output.append("\\5C ");
                    break;
                // HTML chars for closing the parent context
                case '&':
                    output.append("\\26 ");
                    break;
                case '/':
                    output.append("\\2F ");
                    break;
                case '<':
                    output.append("\\3C ");
                    break;
                case '>':
                    output.append("\\3E ");
                    break;
                // Unicode
                case '\u2028':
                    output.append("\\002028 ");
                    break;
                case '\u2029':
                    output.append("\\002029 ");
                    break;

                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }

    public static String sqlLikeClause(String input) {
        return sqlLikeClause(input, '@');
    }

    public static String sqlLikeClause(String input, char escape) {
        if (input == null)
            return null;

        int length = input.length();
        StringBuilder output = allocateStringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == escape || c == '_' || c == '%') {
                output.append(escape);
            }
            output.append(c);
        }
        return output.toString();
    }

    private static StringBuilder allocateStringBuilder(int length) {
        // Allocate enough temporary buffer space to avoid reallocation in most
        // cases. If you believe you will output large amount of data at once
        // you might need to change the factor.
        int buflen = length;
        if (length * 2 > 0)
            buflen = length * 2;
        return new StringBuilder(buflen);
    }
}
