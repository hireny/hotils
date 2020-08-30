package org.hotilsframework.lang;

import org.hotilsframework.lang.matchs.CharMatcher;

/**
 * 名字中的格式
 * @ClassName: NameCaseFormat
 * @Author: hireny
 * @Date: Created in 2020-02-14 23:08
 * @Version: 1.0
 */
public enum CaseFormat {

    /**
     * Hyphenated variable naming convention, e.g., "lower-hyphen".
     * 用连字符连接的变量命名惯例， e.g., "lower-hyphen"
     */
    LOWER_HYPHEN(CharMatcher.is('-'), "-") {
        @Override
        String normalizeWord(String word) {
            return null;
        }
    },
    /**
     * C++ variable naming convention, e.g., "lower_underscore".
     * C++中的变量命名约定，例如："lower_underscore"。
     */
    LOWER_UNDERSCORE(CharMatcher.is('_'), "_") {
        @Override
        String normalizeWord(String word) {
            return null;
        }
    },
    /**
     * Java variable naming convention, e.g., "lowerCamel".
     * Java中的变量命名约定，例如："lowerCamel"。
     */
    LOWER_CAMEL(CharMatcher.range('A', 'Z'), "") {
        @Override
        String normalizeWord(String word) {
            return null;
        }
    },
    /**
     * Java and C++ class naming convention, e.g., "UpperCamel".
     * Java 和 C++ 中的类命名约定，例如："UpperCamel".
     */
    UPPER_CAMEL(CharMatcher.range('A', 'Z'), "") {
        @Override
        String normalizeWord(String word) {
            return null;
        }
    },
    /**
     * Java and C++ constant naming convention, e.g., "UPPER_UNDERSCORE".
     * Java 和 C++ 常量命名约定，例如："UPPER_UNDERSCORE"
     */
    UPPER_UNDERSCORE(CharMatcher.is('_'), "_") {
        @Override
        String normalizeWord(String word) {
            return null;
        }
    }
    ;
    /**
     * 单词之间的边界
     */
    private final CharMatcher wordBoundary;
    /**
     * 每个单词之间的分隔符
     */
    private final String wordSeparator;

    /**
     * Constructor
     * @param wordBoundary
     * @param wordSeparator
     */
    CaseFormat(CharMatcher wordBoundary, String wordSeparator) {
        this.wordBoundary = wordBoundary;
        this.wordSeparator = wordSeparator;
    }

    /**
     * 命名转换，根据命名规则，转换字符串
     * @param format
     * @param s
     * @return
     */
    String convert(CaseFormat format, String s) {
        return null;
    }

    /**
     * 单词正常化
     * @param word
     * @return
     */
    abstract String normalizeWord(String word);
}
