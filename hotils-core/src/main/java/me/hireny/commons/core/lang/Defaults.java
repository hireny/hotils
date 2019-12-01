package me.hireny.commons.core.lang;

import me.hireny.commons.utils.Assert;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/11 01:39
 */
public class Defaults {

    private Defaults() {}

    /**
     * Double 默认值
     */
    private static final Double DOUBLE_DEFAULT = 0D;
    /**
     * Float 默认值
     */
    private static final Float FLOAT_DEFAULT = 0F;

    /**
     * 返回默认值
     * @param type
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T defaultValue(Class<T> type) {
        Assert.checkNotNull(type);
        if (type == boolean.class) {
            return (T) Boolean.FALSE;
        } else if (type == char.class) {
            return (T) Character.valueOf('\0');
        } else if (type == byte.class) {
            return (T) Byte.valueOf((byte) 0);
        } else if (type == short.class) {
            return (T) Short.valueOf((short) 0);
        } else if (type == int.class) {
            return (T) Integer.valueOf(0);
        } else if (type == long.class) {
            return (T) Long.valueOf(0L);
        } else if (type == float.class) {
            return (T) FLOAT_DEFAULT;
        } else if (type == double.class) {
            return (T) DOUBLE_DEFAULT;
        } else {
            return null;
        }
    }
}
