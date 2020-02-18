package org.hotilsframework.core.logging.layout.pattern;

/**
 * 关键字节点
 * @author hireny
 * @className KeywordNode
 * @create 2020-02-18 20:56
 */
public class KeywordNode extends Node {

    public KeywordNode(String value) {
        super(Node.KEYWORD, value);
    }

    public String getKeyword() {
        return value.substring(1);
    }
}
