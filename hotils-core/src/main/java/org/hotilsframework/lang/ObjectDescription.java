package org.hotilsframework.lang;

/**
 * ObjectDescription
 *
 *  用来描述对象本身
 *
 * @author hireny
 * @create 2020-11-09 10:23
 */
public interface ObjectDescription {
    /**
     * 附加一些纯文本描述。
     *
     * @param value
     * @return
     */
    ObjectDescription append(String value);

    /**
     * 附加一个任意值描述。
     *
     * @param value
     * @return
     */
    ObjectDescription append(Object value);

    /**
     * 附加可变参数的值描述。
     *
     * @param values
     * @param <T>
     * @return
     */
    <T> ObjectDescription append(T value, T... values);

    /**
     * 附加一个列表的值描述。
     * @param values
     * @param <T>
     * @return
     */
    <T> ObjectDescription append(Iterable<T> values);

    /**
     * 对象描述类的描述
     * @return
     */
    @Override
    String toString();

    static ObjectDescription of(Object value) {
        return new ObjectDescription() {
            @Override
            public ObjectDescription append(String value) {
                return null;
            }

            @Override
            public ObjectDescription append(Object value) {
                return null;
            }

            @SafeVarargs
            @Override
            public final <T> ObjectDescription append(T value, T... values) {
                return null;
            }

            @Override
            public <T> ObjectDescription append(Iterable<T> values) {
                return null;
            }

            @Override
            public String toString() {
                return value.toString();
            }
        };
    }
}
