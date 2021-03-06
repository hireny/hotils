package org.hotilsframework.lang.reflects;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * TypeWrapper
 * 类型的包装类
 * @Author: hireny
 * @Date: Create in 2019/10/31 11:02
 */
public class TypeWrapper {
    /**
     * 需要解析的 JDK 类型
     */
    private final Type type;

    public TypeWrapper(Type type) {
        this.type = type;
    }


    interface TypeProvider extends Serializable {

        /**
         * 返回Type类型
         * @return
         */
        Type getType();

        /**
         * 返回目标对象
         * @return
         */
        default Object getSource() {
            return null;
        }
    }


}
