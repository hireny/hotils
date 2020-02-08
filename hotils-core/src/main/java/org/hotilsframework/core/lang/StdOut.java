package org.hotilsframework.core.lang;

import org.hotilsframework.core.io.Charsets;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * 标准输出
 * @ClassName: StdOut
 * @Author: hireny
 * @Date: Created in 2020-02-08 14:41
 * @Version: 1.0
 */
public final class StdOut {

    private static final String CHARSET_NAME = "UTF-8";

    private static PrintWriter out;

    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, Charsets.UTF_8), true);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    // don't instantiate
    private StdOut() {}

    public static void println() {
        out.println();
    }

    public static void println(Object x) {
        out.println(x);
    }

    public static void println(boolean x) {
        out.println(x);
    }

    public static void println(char x) {
        out.println(x);
    }

    public static void println(double x) {
        out.println(x);
    }

    public static void println(float x) {
        out.println(x);
    }

    public static void println(long x) {
        out.println(x);
    }

    public static void println(int x) {
        out.println(x);
    }

    public static void println(short x) {
        out.println(x);
    }

    public static void println(byte x) {
        out.println(x);
    }

    public static void print() {
        out.flush();
    }

    /**
     * Prints an object to standard output and flushes standard output.
     *
     * @param x the object to print
     */
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a boolean to standard output and flushes standard output.
     *
     * @param x the boolean to print
     */
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a character to standard output and flushes standard output.
     *
     * @param x the character to print
     */
    public static void print(char x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a double to standard output and flushes standard output.
     *
     * @param x the double to print
     */
    public static void print(double x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a float to standard output and flushes standard output.
     *
     * @param x the float to print
     */
    public static void print(float x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints an integer to standard output and flushes standard output.
     *
     * @param x the integer to print
     */
    public static void print(int x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a long integer to standard output and flushes standard output.
     *
     * @param x the long integer to print
     */
    public static void print(long x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a short integer to standard output and flushes standard output.
     *
     * @param x the short integer to print
     */
    public static void print(short x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a byte to standard output and flushes standard output.
     *
     * @param x the byte to print
     */
    public static void print(byte x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a formatted string to standard output, using the locale and
     * the specified format string and arguments; then flushes standard output.
     *
     * @param locale the locale
     * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
     * @param args   the arguments accompanying the format string
     */
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }

}
