package org.hotilsframework.core.factory;

/**
 * @ClassName: DefaultValidator
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:22
 * @Description: TODO   这个是默认的对象验证器
 */
public class DefaultValidator implements Validator {
    @Override
    public boolean isValid(Object o) {
        return true;
    }

    @Override
    public void invalidate(Object o) {

    }
}
