package org.hotilsframework.jcl.layout;

import org.hotilsframework.jcl.LoggingEvent;
import org.hotilsframework.jcl.layout.pattern.Node;
import org.hotilsframework.jcl.layout.pattern.PatternParser;

import java.util.List;

/**
 * 可配置的字符串模板布局
 * @author hireny
 * @className PatternLayout
 * @create 2020-02-18 13:49
 */
public class PatternLayout implements Layout {

    /**
     * 正则字符串
     */
    private String        pattern;
    /**
     * 正则解析器
     */
    private PatternParser patternParser;
    /**
     * 节点集合
     */
    private List<Node>    nodes;
    

    @Override
    public String doLayout(LoggingEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : nodes) {
            stringBuilder.append(node.getConverter().convert(event));
        }
        return stringBuilder.toString();
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 准备
     */
    private void prepare() {
        this.patternParser = new PatternParser(pattern);
        this.nodes = patternParser.parse();
    }

    @Override
    public void start() {
        prepare();
    }

    @Override
    public void stop() {

    }
}
