package org.hotilsframework.utils;

import org.hotilsframework.core.match.RegexMatcher;
import org.hotilsframework.lang.StringUtils;

/**
 * Sensitives
 *
 * 敏感数据
 *
 * @author hireny
 * @create 2020-11-07 21:10
 */
public class Sensitives {
    /** 是否进行敏感数据屏蔽的开关 */
    private static boolean flag = true;

    /**
     * 构造函数
     * @param flag 是否需要进行屏蔽的开关
     */
    public Sensitives(final boolean flag) {
        Sensitives.flag(flag);
    }

    /**
     * 构造函数，默认开启屏蔽开关
     */
    public Sensitives() {
        Sensitives.flag(true);
    }

    /**
     * 对大陆身份证号进行部分隐藏处理，只显示前1位和后1位，其它用*代替。
     * 如果valid为true且传入的数据不是合法的大陆身份证号，将按敏感信息缺省隐藏方式处理，显示前1/3和后1/3，其它用*代替。
     *
     * @param identification 待部分隐藏处理的身份证号。
     * @param valid 是否做身份证合法性验证。警告：做校验会进行正则匹配，性能上比不做校验的方法略有损耗。
     * @return 如果 flag 为 true，返回符合规范的身份证号部分展示字符串，否则返回原数据
     */
    public static String identification(final String identification, final boolean valid) {
        if (!isOpen()) {
            return identification;
        }
        if (StringUtils.isBlank(identification)) {
            return identification;
        }

        if (valid) {
            if (!RegexMatcher.checkIdCard(identification)) {
                return value(identification);   // 不是大陆身份证号，按缺省的隐藏显示方法。
            }
        }
        return value(identification, 1, 1, identification.length() - 2);
    }

    public static String value(final String data) {
        if (!isOpen()) {
            return data;
        }
        if (StringUtils.isBlank(data)) {
            return data;
        }
        String tmp = data.trim();
        int length = tmp.length();
        int headNum = (int) Math.ceil(length * 1 / 3.0);
        int tailNum = (int) Math.floor(length * 1 / 3.0);
        return value(tmp, headNum, tailNum, length - headNum- tailNum);
    }

    /**
     * 自定义屏蔽位数和屏蔽位置
     *
     * @param data      原数据
     * @param front     展示前几位
     * @param tail      展示后几位
     * @param hidden    展示星号*的个数
     * @return
     */
    public static String value(final String data, final int front, final int tail, final int hidden) {
        if (StringUtils.isBlank(data)) {
            return data;
        }
        String tmp = data.trim();
        int length = tmp.length();
        // 合法性检查，如果参数不合法，返回原数据内容
        if (front < 0 || tail < 0 || hidden < 0 || front + tail > length) {
            return tmp;
        }

        int begin = front - 1;
        int end = length - 1;

        // 原数据前半部分
        StringBuilder result = new StringBuilder();
        if (begin >= 0 && begin < length) {
            result.append(tmp.substring(0, front));
        }

        // 中间*
        for (int i = 0; i < hidden; i++) {
            result.append('*');
        }

        // 原数据后半部分
        if (end >= 0 && end < length) {
            result.append(tmp.substring(end));
        }

        return result.toString();
    }

    /**
     * 敏感数据开关
     * @param flag
     */
    public static void flag(final boolean flag) {
        Sensitives.flag = flag;
    }

    /**
     *
     * @return 是否屏蔽
     */
    public static boolean isOpen() {
        return Sensitives.flag;
    }
}
