package org.hotilsframework.inject;

/**
 * EventModule
 * 类描述
 *
 * @author hireny
 * @create 2020-07-27 0:03
 */
public class SimpleModule extends AbstractModule {

    @Override
    public void configure() {
        // 表明：当需要 Communicator 这个变量时，我们注入 DefaultCommunicatorImpl 的实例作为依赖
        bind(LogService.class).to(LogServiceImpl1.class);
//        bind(LogService.class).to(LogServiceImpl2.class);
    }
}
