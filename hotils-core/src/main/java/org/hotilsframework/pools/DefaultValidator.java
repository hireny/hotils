package org.hotilsframework.pools;

/**
 * @ClassName: DefaultValidator
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:22
 * @Description: TODO   这个是默认的对象验证器
 */
public class DefaultValidator<T> implements Validator<T> {
    @Override
    public boolean isValid(T t) {
        return true;
    }

    @Override
    public void invalidate(T t) {

    }
}
