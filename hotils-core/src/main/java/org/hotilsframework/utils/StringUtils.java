package org.hotilsframework.utils;

import org.hotilsframework.core.text.StringFormatters;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Strings
 * @Author: hireny
 * @Date: Create in 2019/11/25 22:56
 * @Description: TODO   字符串工具
 */
public final class StringUtils {
    private StringUtils() {}

    //-------------------------------------------------------
    // General convenience methods for working with Strings
    // 处理字符串的一般的简便方法
    //-------------------------------------------------------

    /**
     * 判断字符串是否为空
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0 || "".contentEquals(cs);
    }

    /**
     * 判断字符串是否为空或空白
     * @param cs
     * @return
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /**
     * 判断字符串是null或空字符串
     * @param string
     * @return
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * Check that the given {@code CharSequence} is neither {@code null} nor of length 0.
     * 检查给定的 {@code CharSequence} 既不是为null也不是长度为0
     * @param str
     * @return
     */
    public static boolean hasLength(String str) {
        return (str != null || str.length() > 0);
    }

    /**
     * 检查给定的 {@code CharSequence} 存在文本
     * @param str
     * @return
     */
    public static boolean hasText(String str) {
        return (str != null || str.length() > 0 || isBlank(str));
    }

    /**
     * 判断两个字符串是否相同
     *
     * @param a 作为对比的字符串
     * @param b 作为对比的字符串
     * @return 是否相同
     */
    public static boolean equals(String a, String b) {
        return ObjectUtils.equals(a, b);
    }

    /**
     * 判断是否为空字符串，为""字符串返回null，不为 "" 则返回原本字符串
     * @param string
     * @return
     */
    public static String emptyToNull(String string) {
        return isNullOrEmpty(string) ? null : string;
    }

    /**
     * null 转 空字符串
     *
     * @param obj 对象
     * @return 将 null 对象返回空字符串(""), 其他对象调用 toString() 返回的字符串
     */
    public static String nullToEmpty(Object obj) {
        return (obj == null ? "" : (obj instanceof String ? (String) obj : obj.toString()));
    }

    /**
     * 取出开头和结尾的空白
     */
    public static String trimWhiteSpace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        int beginIndex = 0;
        int endIndex = str.length() - 1;

        while (beginIndex <= endIndex && Character.isWhitespace(str.charAt(beginIndex))) {
            beginIndex++;
        }

        while (endIndex > beginIndex && Character.isWhitespace(str.charAt(endIndex))) {
            endIndex--;
        }

        return str.substring(beginIndex, endIndex + 1);
    }

    /**
     * 取出字符串中所有的空白 例如： " hello, World ! " -> "hello,World!"
     */
    public static String trimAllWhiteSpace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        int len = str.length();
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 首字母小写
     * @param str
     * @return
     */
    public static String decapitalize(String str) {
        if (str != null && str.length() != 0) {
            if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
                return str;
            } else {
                char[] chars = str.toCharArray();
                chars[0] = Character.toLowerCase(chars[0]);
                return new String(chars);
            }
        } else {
            return str;
        }
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String capitalize(String str) {
        if (str != null && str.length() != 0) {
            char[] chars = str.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return new String(chars);
        } else {
            return str;
        }
    }

    /**
     * 返回一个字符串，其长度至少为minLength，
     * 如果string长度小于minLength，则在字符串的前面添加若干个padChar，知道长度为minLength;
     * 如果长度大于minLength则直接返回字符串。
     * @param string
     * @param minLength
     * @param padChar
     * @return
     */
    public static String padStart(String string, int minLength, char padChar) {
        Assert.checkNotNull(string); //断言不为空
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(minLength);
        for (int i = string.length(); i < minLength; i++) {
            stringBuilder.append(padChar);
        }
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    /**
     * 返回一个字符串，其长度至少为minLength，
     * 如果string长度小于minLength，则在字符串的后面添加若干个padChar，知道长度为minLength;
     * 如果长度大于minLength则直接返回字符串。
     * @param string
     * @param minLength
     * @param padChar
     * @return
     */
    public static String padEnd(String string, int minLength, char padChar) {
        Assert.checkNotNull(string); //断言不为空
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(minLength);
        stringBuilder.append(string);
        for (int i = string.length(); i < minLength; i++) {
            stringBuilder.append(padChar);
        }
        return stringBuilder.toString();
    }

    /**
     * 将一个字符串重复几次之后再输出.
     * @param string
     * @param count
     * @return
     */
    public static String repeat(String string, int count) {
        // 首先判断输入的参数是否合法
        Assert.checkNotNull(string);
        if (count <= 1) {
//            checkArgument(count >= 0, "invalid count: %s", count);
            return (count == 0) ? "" : string;
        }

        // IF YOU MODIFY THE CODE HERE, you must update StringsRepeatBenchmark
        final int len = string.length();
        final long longSize = (long) len * (long) count;
        final int size = (int) longSize;
        // 如果字符长度超出int范围则抛出错误
        if (size != longSize) {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + longSize);
        }

        final char[] array = new char[size];
        // 将字符串中的字符复制到目标字符数组中，实际也调用了System.arraycopy这个本地方法
        string.getChars(0, len, array, 0);
        int n;
        // 这里使用到了移位运算，使得每次复制的数据都是上一次的2倍，总的循环的次数变为log（count）次，提高了效率
        for (n = len; n < size - n; n <<= 1) {
            System.arraycopy(array, 0, array, n, n);
        }
        // 如果count为奇数，则还要进行依次额外的复制操作
        System.arraycopy(array, 0, array, n, size - n);
        return new String(array);
    }

    /**
     * 获取两个字符串相同跟的后缀
     * @param a     字符串；例如： "abcabcabc"
     * @param b     字符串；例如： "abcbcabca"
     * @return  String 返回 "abc"，如果不相同，则返回 ""
     */
    public static String getSamePrefix(String a, String b) {
        Assert.checkNotNull(a);
        Assert.checkNotNull(b);
        int maxPrefixLength = Math.min(a.length(), b.length());
        int p = 0;
        while (p < maxPrefixLength && a.charAt(p) == b.charAt(p)) {
            p++;
        }
        if (validSurrogatePairAt(a, p - 1) || validSurrogatePairAt(b, p - 1)) {
            p--;
        }
        return a.subSequence(0, p).toString();
    }

    /**
     * 获取两个字符串相同跟的后缀
     * @param a     字符串；例如： "abcabcbca"
     * @param b     字符串；例如： "abcbcabca"
     * @return  String 返回 "bca"，如果不相同，则返回 ""
     */
    public static String getSameSuffix(String a, String b) {
        Assert.checkNotNull(a);
        Assert.checkNotNull(b);
        int maxSuffixLength = Math.min(a.length(), b.length());
        int s = 0;
        while (s < maxSuffixLength && a.charAt(a.length() - s - 1) == b.charAt(b.length() - s - 1)) {
            s++;
        }
        if (validSurrogatePairAt(a, a.length() - s - 1)
                || validSurrogatePairAt(b, b.length() - s - 1)) {
            s--;
        }
        return a.subSequence(a.length() - s, a.length()).toString();
    }

    static boolean validSurrogatePairAt(CharSequence cs, int index) {
        return index >= 0
                && index <= (cs.length() - 2)
                && Character.isHighSurrogate(cs.charAt(index))
                && Character.isLowSurrogate(cs.charAt(index + 1));
    }

    /**
     * 格式化文本, {} 表示占位符
     * 此方法只是简单将占位符{} 按照顺序替换为参数
     * 如果想输出{}使用\\转移 { 即可，如果想输出 {} 之前 \ 使用双转义符 \\\\ 即可
     * 例子：
     *  通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 	转义{}： format("this is \\{} for {}", "a", "b") =》 this is \{} for a<br>
     * 	转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     * @param cs        文本模板，被替换的部分用{}表示
     * @param params    参数值
     * @return          格式化后的文本
     */
    public static String format(CharSequence cs, Object... params) {
        if (null == cs) {
            return null;
        }
        if (ArrayUtils.isEmpty(params) || isBlank(cs)) {
            return cs.toString();
        }
        return StringFormatters.format(cs.toString(), params);
    }

    /**
     * 将对象转为字符串
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组
     * 2、对象数组会调用Arrays.toString方法
     * @param object    对象
     * @return          字符串
     */
    public static String stringForUtf8(Object object) {
        return string(object, Charset.forName("UTF-8"));
    }

    /**
     * 将对象转换为字符串
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组
     * 2、对象数组会调用Arrays.toString方法
     * @param object        对象
     * @param charsetName   字符集
     * @return              字符串
     */
    public static String string(Object object, String charsetName) {
        return string(object, Charset.forName(charsetName));
    }

    public static String string(Object object, Charset charset) {
        if (null == object) {
            return null;
        }

        if (object instanceof String) {
            return (String) object;
        } else if (object instanceof byte[]) {
            return string((byte[]) object, charset);
        } else if (object instanceof Byte[]) {
            return string((Byte[]) object, charset);
        } else if (object instanceof ByteBuffer) {
            return string((ByteBuffer) object, charset);
        } else if (object.getClass().isArray()) {
            return ObjectUtils.toString(object);
        }

        return object.toString();
    }

    /**
     * 将byte数组转为字符串
     *
     * @param bytes byte数组
     * @param charset 字符集
     * @return 字符串
     */
    public static String string(byte[] bytes, String charset) {
        return string(bytes, isBlank(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    /**
     * 解码字节码
     *
     * @param data 字符串
     * @param charset 字符集，如果此字段为空，则解码的结果取决于平台
     * @return 解码后的字符串
     */
    public static String string(byte[] data, Charset charset) {
        if (data == null) {
            return null;
        }

        if (null == charset) {
            return new String(data);
        }
        return new String(data, charset);
    }

    /**
     * 将Byte数组转为字符串
     *
     * @param bytes byte数组
     * @param charset 字符集
     * @return 字符串
     */
    public static String string(Byte[] bytes, String charset) {
        return string(bytes, isBlank(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    /**
     * 解码字节码
     *
     * @param data 字符串
     * @param charset 字符集，如果此字段为空，则解码的结果取决于平台
     * @return 解码后的字符串
     */
    public static String string(Byte[] data, Charset charset) {
        if (data == null) {
            return null;
        }

        byte[] bytes = new byte[data.length];
        Byte dataByte;
        for (int i = 0; i < data.length; i++) {
            dataByte = data[i];
            bytes[i] = (null == dataByte) ? -1 : dataByte;
        }

        return string(bytes, charset);
    }

    /**
     * 将编码的byteBuffer数据转换为字符串
     *
     * @param data 数据
     * @param charset 字符集，如果为空使用当前系统字符集
     * @return 字符串
     */
    public static String string(ByteBuffer data, String charset) {
        if (data == null) {
            return null;
        }

        return string(data, Charset.forName(charset));
    }

    /**
     * 将编码的byteBuffer数据转换为字符串
     *
     * @param data 数据
     * @param charset 字符集，如果为空使用当前系统字符集
     * @return 字符串
     */
    public static String string(ByteBuffer data, Charset charset) {
        if (null == charset) {
            charset = Charset.defaultCharset();
        }
        return charset.decode(data).toString();
    }

    /**
     * {@link CharSequence} 转为字符串，null安全
     *
     * @param cs {@link CharSequence}
     * @return 字符串
     */
    public static String string(CharSequence cs) {
        return null == cs ? null : cs.toString();
    }

//    /**
//     * 将集合转换为中间使用分隔符 {@code delim} 隔开的字符串
//     * @param coll
//     * @param delim
//     * @return
//     */
//    public static String collectionToDelimitedString(Collection<?> coll, String delim) {
//        return collectionToDelimitedString(coll, delim, "", "");
//    }
//
//    /**
//     * 将集合转换为中间使用逗号(,)隔开的字符串
//     * @param coll
//     * @return
//     */
//    public static String collectionToCommaDelimitedString(Collection<?> coll) {
//        return collectionToDelimitedString(coll, ",");
//    }
//
//    /**
//     * 将集合转换为中间使用分隔符 {@code delim} 隔开的字符串，并且字符串前后带有前缀和后缀
//     * @param coll      集合
//     * @param delim     中间隔开的字符串
//     * @param prefix    前缀
//     * @param suffix    后缀
//     * @return  String 例如：[a,b,c,d] -> "$a,b,c,d^"(,为分隔符；$为前缀；^为后缀)
//     */
//    public static String collectionToDelimitedString(
//            Collection<?> coll, String delim, String prefix, String suffix) {
//        if (Collections.isEmpty(coll)) {
//            return "";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        Iterator<?> it = coll.iterator();
//        while (it.hasNext()) {
//            sb.append(prefix).append(it.next()).append(suffix);
//            if (it.hasNext()) {
//                sb.append(delim);
//            }
//        }
//        return sb.toString();
//    }

    /**
     * 字符串转换类
     */
    public static class StringConverters {

        private static Pattern linePattern = Pattern.compile("_(\\w)");

        /**
         * 转换为驼峰
         * @param s
         * @return
         */
        public static String toHunmp(String s) {
            s = s.toLowerCase();
            Matcher matcher = linePattern.matcher(s);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, matcher.group(1).toLowerCase());
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }

        private static Pattern humpPattern = Pattern.compile("[A-Z]");

        /**
         * 转换为下划线
         * @param s
         * @return
         */
        public static String toLine(String s) {
            Matcher matcher = humpPattern.matcher(s);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, "_" + matcher.group(0).toLowerCase());
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
    }
}
