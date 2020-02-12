package org.hotilsframework.core.logging;

/**
 * 抽象类输出源
 * @ClassName: AbstractAppender
 * @Author: hireny
 * @Date: Created in 2020-02-12 19:03
 * @Version: 1.0
 */
public abstract class AbstractAppender implements Appender {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void append(LoggingEvent event) {

    }
}
