package me.hireny.commons.json.tokenizer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 存储此法解析所得的token流
 * @Author: hireny
 * @Date: Create in 2019/07/16 20:24
 */
public class TokenReader {

    /**
     * 该集合为存储对应类型和字面量的标记类的集合类
     */
    private List<Token> tokens;
    /**
     * 对于tokens集合实例的索引
     */
    private int index;

    {
        tokens = new CopyOnWriteArrayList<>();
        index = 0;
    }

    /**
     * 将表积累添加到集合List中
     * @param token
     */
    public void add(Token token) {
        tokens.add(token);
    }

    /**
     * 返回 index 下标处的 Token，若无，返回null
     * @return
     */
    public Token peek() {
        return index < tokens.size() ? tokens.get(index) : null;
    }

    /**
     *
     * @return
     */
    public Token peekPrevious() {
        return index -1 < 0 ? null : tokens.get(index - 2);
    }

    /**
     * 遍历下一个Token对象
     * @return
     * @throws Exception
     */
    public Token next() {
        return tokens.get(index++);
    }

    /**
     * 判断Token流是否结束
     * @return
     */
    public boolean hasMore() {
        return index < tokens.size();
    }

    @Override
    public String toString() {
        return "TokenReader{" +
                "tokens=" + tokens +
                ", index=" + index +
                '}';
    }
}
