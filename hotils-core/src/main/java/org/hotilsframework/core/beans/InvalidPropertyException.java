package org.hotilsframework.core.beans;

/**
 * 验证属性异常
 * @ClassName: InvalidPropertyException
 * @Author: hireny
 * @Date: Created in 2020-02-01 22:51
 * @Version: 1.0
 */
public class InvalidPropertyException extends FatalBeansException {
    private static final long serialVersionUID = 5871708317417960460L;

    private final Class<?> beanClass;

    private final String propertyName;

    /**
     * 构造
     * @param beanClass
     * @param propertyName
     * @param msg
     */
    public InvalidPropertyException(Class<?> beanClass, String propertyName, String msg) {
        this(beanClass, propertyName, msg, null);
    }

    /**
     * 构造
     */
    public InvalidPropertyException(Class<?> beanClass, String propertyName, String msg, Throwable cause) {
        super("Invalid property '" + propertyName + "' of bean class [" + beanClass.getName() + "]: " + msg, cause);
        this.beanClass = beanClass;
        this.propertyName = propertyName;
    }

    /**
     * 返回Bean类
     */
    public Class<?> getBeanClass() {
        return this.beanClass;
    }

    /**
     * 返回属性名
     */
    public String getPropertyName() {
        return this.propertyName;
    }

}
