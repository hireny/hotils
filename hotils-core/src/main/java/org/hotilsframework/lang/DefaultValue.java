package org.hotilsframework.lang;

/**
 * DefaultValue
 *
 * 默认值
 *
 * @author hireny
 * @create 2020-12-02 16:45
 */
@FunctionalInterface
public interface DefaultValue<T> {
    /**
     * 根据传入的类型返回默认值
     * @param clazz
     * @return      返回值
     */
    T get(Class<T> clazz);

    /**
     * Double 默认值
     */
    Double DOUBLE_DEFAULT = 0D;
    /**
     * Float 默认值
     */
    Float FLOAT_DEFAULT = 0F;

    /**
     * 根据类型获取值
     *
     * @param type  类型
     * @param <T>
     * @return      返回值
     */
    @SuppressWarnings("unchecked")
    static <T> T getValue(Class<T> type) {
        Assert.notNull(type);
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
        }
        return null;
    }
}
