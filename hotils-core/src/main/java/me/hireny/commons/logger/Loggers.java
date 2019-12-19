package me.hireny.commons.logger;

import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * @ClassName: Loggers
 * @Author: hireny
 * @Date: Create in 2019/12/13 11:42
 * @Description: TODO   日志封装
 */
public final class Loggers {
    private Loggers() {}

    /**
     * trace级别日志信息
     *
     * @param logger        日志记录对象
     * @param message       日志信息
     * @param arguments     参数
     */
    public static void trace(Logger logger, String message, String... arguments) {
        if (logger.isTraceEnabled()) {
            logger.trace(MessageFormat.format(message, arguments));
        }
    }

    /**
     * trace级别日志信息
     *
     * @param logger 日志记录对象
     * @param e 抛出的异常
     * @param message 日志信息
     * @param arguments 参数
     */
    public static void trace(Logger logger, Throwable e, String message, String... arguments) {
        if (logger.isTraceEnabled())
            logger.trace(MessageFormat.format(message, arguments), e);
    }


    /**
     * debug级别日志信息
     *
     * @param logger 日志记录对象
     * @param message 日志信息
     * @param arguments 参数
     */
    public static void debug(Logger logger, String message, String... arguments) {
        if (logger.isDebugEnabled())
            logger.debug(MessageFormat.format(message, arguments));
    }


    /**
     * debug级别日志信息
     *
     * @param logger 日志记录对象
     * @param e the exception (throwable) to log
     * @param message 日志信息
     * @param arguments 参数
     */
    public static void debug(Logger logger, Throwable e, String message, String... arguments) {
        if (logger.isDebugEnabled())
            logger.debug(MessageFormat.format(message, arguments), e);
    }

    /**
     * info级别日志信息
     *
     * @param logger 日志记录对象
     * @param message 日志信息
     * @param arguments 参数
     */
    public static void info(Logger logger, String message, String... arguments) {
        if (logger.isInfoEnabled())
            logger.info(MessageFormat.format(message, arguments));
    }

    /**
     * info级别日志信息
     *
     * @param logger
     * @param e  the exception (throwable) to log
     * @param message
     * @param arguments
     */
    public static void info(Logger logger, Throwable e, String message, String... arguments) {
        if (logger.isInfoEnabled())
            logger.info(MessageFormat.format(message, arguments), e);
    }

    /**
     *
     * @param logger
     * @param message
     * @param arguments
     */
    public static void warn(Logger logger, String message, String... arguments) {
        if (logger.isWarnEnabled())
            logger.warn(MessageFormat.format(message, arguments));
    }

    /**
     * warn级别日志信息
     *
     * @param logger
     * @param e  the exception (throwable) to log
     * @param message
     * @param arguments
     */
    public static void warn(Logger logger,  Throwable e, String message, String... arguments) {
        if (logger.isWarnEnabled())
            logger.warn(MessageFormat.format(message, arguments), e);
    }

    /**
     * error级别日志信息
     *
     * @param logger
     * @param message
     * @param arguments
     */
    public static void error(Logger logger, String message, String... arguments) {
        if (logger.isErrorEnabled())
            logger.error(MessageFormat.format(message, arguments));
    }

    /**
     * error级别日志信息
     *
     * @param logger
     * @param e the exception (throwable) to log
     * @param message
     * @param arguments
     */
    public static void error(Logger logger, Throwable e, String message, String... arguments) {
        if (logger.isErrorEnabled())
            logger.error(MessageFormat.format(message, arguments), e);
    }
}
