package org.hotilsframework.inject;

import org.junit.Test;

/**
 * 注入框架测试
 * @author hireny
 * @className InjectTest
 * @create 2020-05-17 23:12
 */
public class InjectTest {

    @Test
    public void injectTest() {
        // 这步就是我们向Injectors去要对象
        final Injector injector = Injectors.createInjector(new SimpleConfiguration());
        System.out.println(injector.getClass());
        System.out.println("绑定信息");
        System.out.println(injector.getBindings());
//        Key<LogService> key = Key.get(LogService.class, Qualifiers.byName("logService"));
        LogService logService = injector.getInstance(LogService.class);
//        LogService logService = injector.getInstance(key);
        System.out.println(logService);
        logService.log("简单测试");
        LogService logService1 = injector.getInstance(LogService.class);
//        LogService logService1 = injector.getInstance(key);
        System.out.println(logService1);
        logService1.log("第二次测试");

        System.out.println("两个对象是否相等 = " + (logService == logService1));
    }
}
