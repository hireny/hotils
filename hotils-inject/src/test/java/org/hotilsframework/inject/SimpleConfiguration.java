package org.hotilsframework.inject;

/**
 * EventModule
 * 类描述
 *
 * @author hireny
 * @create 2020-07-27 0:03
 */
public class SimpleConfiguration extends AbstractConfiguration {

    @Override
    public void configure() {
        // 表明：当需要 Communicator 这个变量时，我们注入 DefaultCommunicatorImpl 的实例作为依赖
//        bind(LogService.class).annotatedWith(Qualifiers.byName("logService")).to(LogServiceImpl1.class).in(Singleton.class);
        bind(LogService.class).to(LogServiceImpl2.class);
    }
}
