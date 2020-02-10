package org.hotilsframework.core.logger;

import org.junit.Test;

/**
 * @ClassName: LoggerTest
 * @Author: hireny
 * @Date: Created in 2020-02-10 23:10
 * @Version: 1.0
 */
public class LoggerTest {

    public static final LogManager logManager = new LogManager();

    public static void main(String[] args) {
        Logger logger = logManager.getLogger();
        Logger maClasseLogger = logManager.getLogger(LoggerTest.class);
        Logger customLogger = logManager.getLogger("esiea");

        logger.info("Connection to prod3.edu database");
    }
}
