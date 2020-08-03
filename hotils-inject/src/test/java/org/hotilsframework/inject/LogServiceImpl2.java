package org.hotilsframework.inject;

/**
 * LogServiceImpl2
 * 类描述
 *
 * @author hireny
 * @create 2020-08-03 0:05
 */
public class LogServiceImpl2 implements LogService {
    @Override
    public void log(String msg) {
        System.out.println("-------LOG2:" + msg);
    }
}
