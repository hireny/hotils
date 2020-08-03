package org.hotilsframework.inject;

/**
 * UserServiceImpl
 * 类描述
 *
 * @author hireny
 * @create 2020-07-27 0:15
 */
public class UserServiceImpl implements UserService {
    @Override
    public void process() {
        System.out.println("做一些业务逻辑");
    }
}
