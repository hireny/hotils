package org.hotilsframework.json.tokenizer;

/**
 * 存储对应类型和字面量的标记类
 * @Author: hireny
 * @Date: Create in 2019/07/16 20:23
 */
public class Token {

    /*
            存储的是 value值和该值对应的type类型
            例如： value=1，type=NUMBER
                  value=username, type= STRING
                  value={  , type=BEGIN_OBJECT
     */

    private TokenType tokenType;
    private String value;

    private Token() {
    }

    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", value='" + value + '\'' +
                '}';
    }
}
