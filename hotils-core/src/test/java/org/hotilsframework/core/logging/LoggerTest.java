package org.hotilsframework.core.logging;

import org.junit.Test;

/**
 * @ClassName: LoggerTest
 * @Author: hireny
 * @Date: Created in 2020-02-10 23:10
 * @Version: 1.0
 */
public class LoggerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        LOGGER.trace("trace: log trace message");
        LOGGER.info("info: log info message");
        LOGGER.debug("debug: log debug message");
        LOGGER.warn("warn: log warn message");
        LOGGER.error("error: log error message");
        LOGGER.fatal("fatal: log fatal message");
    }
}
