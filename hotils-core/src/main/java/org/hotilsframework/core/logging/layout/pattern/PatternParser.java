package org.hotilsframework.core.logging.layout.pattern;

import org.hotilsframework.collect.Lists;
import org.hotilsframework.collect.Maps;
import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.lang.Symbol;
import org.hotilsframework.lang.reflect.ReflectionException;
import org.hotilsframework.core.logging.LoggingEvent;
import org.hotilsframework.utils.ReflectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 解析日志输出规则
 * @author hireny
 * @className PatternParser
 * @create 2020-02-18 20:44
 */
public class PatternParser {

    enum ParserState {
        /**
         * 文字
         */
        LITERAL_STATE,
        /**
         * 关键字
         */
        KEYWORD_STATE;
    }

    private String pattern;
    /**
     * 默认转换的映射关系集
     */
    public static final Map<String, Class> defaultConverterMap = Maps.newHashMap();

    static {
        // put converters to defaultConverterMap.
        // 在默认转换的映射关系集中存放转换器
        defaultConverterMap.put("d", DateConverter.class);
        defaultConverterMap.put("thread", ThreadConverter.class);
        defaultConverterMap.put("msg", MessageConverter.class);
        defaultConverterMap.put("level", LevelConverter.class);
        defaultConverterMap.put("logger", LoggerConverter.class);
        defaultConverterMap.put("pid", ProcessConverter.class);
        defaultConverterMap.put("n", LineSeparatorConverter.class);
    }

    public PatternParser(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 解析
     * @return
     */
    public List<Node> parse() {
        List<Node> nodes = Lists.newArrayList();
        int i = 0;
        char c;
        ParserState state = ParserState.LITERAL_STATE;
        StringBuilder stringBuilder = new StringBuilder();
        int patternLength = pattern.length();
        while (i != patternLength - 1) {
            c = pattern.charAt(i++);
            switch (state) {
                case LITERAL_STATE:
                    // 字符为百分比
                    if (c == Symbol.PER_CENT) {
                        if (stringBuilder.length() > 0) {
                            Node node = new Node(Node.LITERAL, stringBuilder.toString());
                            nodes.add(node);
                            stringBuilder.setLength(0);
                        }
                        state = ParserState.KEYWORD_STATE;
                    }
                    stringBuilder.append(c);
                    break;
                case KEYWORD_STATE:
                    // Character.isJavaIdentifierPart(char ch) 确定指定的字符是Java标识符中除首字符以外的部分。
                    if (!Character.isJavaIdentifierPart(c)) {
                        KeywordNode node = new KeywordNode(stringBuilder.toString());
                        nodes.add(node);
                        state = ParserState.LITERAL_STATE;
                        stringBuilder.setLength(0);
                    }
                    stringBuilder.append(c);
                    break;
            }
        }

        compileNode(nodes);
        return nodes;
    }

    /**
     * 编译节点
     * @param nodes
     */
    private void compileNode(List<Node> nodes) {
        for (Node node : nodes) {
            Converter<LoggingEvent, String> converter = null;
            if (node instanceof KeywordNode) {
                String keyword = ((KeywordNode) node).getKeyword();
                System.out.println("关键字=" + keyword);
                Class<?> clazz = defaultConverterMap.get(keyword);
                if (null == clazz) {
                    // 空指针异常
                    // 匹配的关键字 keyword 是非法的！
                    throw new NullPointerException("pattern [%" + keyword + "] illegal!");
                }
                try {
                    converter = ReflectionUtils.newInstance(clazz);
                } catch (Exception e) {
                    // 反射异常
                    throw new ReflectionException(e);
                }
            } else {
                converter = new LiteralConverter(node.getValue());
            }
            node.converter = converter;
        }
    }
}
