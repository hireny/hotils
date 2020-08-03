package org.hotilsframework.inject;

/**
 * LogServiceImpl
 * 类描述
 *
 * @author hireny
 * @create 2020-07-27 0:16
 */
public class LogServiceImpl1 implements LogService {
    @Override
    public void log(String msg) {
        System.out.println("-------LOG1:" + msg);
    }
}
