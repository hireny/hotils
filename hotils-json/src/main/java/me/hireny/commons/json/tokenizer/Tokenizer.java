package me.hireny.commons.json.tokenizer;

import me.hireny.commons.json.exception.JsonParseException;

import java.io.IOException;

/**
 * 词法解析器
 *
 * @Author: hireny
 * @Date: Create in 2019/07/16 14:35
 */
public class Tokenizer {

    private CharReader charReader;
    private TokenReader tokens;
    private TokenHelper tokenHelper;

    public TokenReader getTokenStream(CharReader charReader) throws IOException, JsonParseException {
        this.charReader = charReader;
        this.tokens = new TokenReader();
        tokenHelper = new TokenHelper(this.charReader);

        // 此法解析，获取token流
        tokenizer();
        return tokens;
    }

    /**
     * 将JSON文件解析成token流
     * @throws IOException
     */
    private void tokenizer() throws IOException, JsonParseException {
        Token token;
        do {
            token = start();
            tokens.add(token);
        } while (token.getTokenType() != TokenType.END_DOCUMENT);
    }


    private Token start() throws IOException, JsonParseException {
        char c;
        // 不是空白字符，就结束该循环，将c字符转换为Token包装起来，并返回
        do {
            // 先读取一个字符，若为空白符
            // (ASCII码在[0, 20H]上)则接着读，
            // 直到刚读的字符非空白符
            if (!charReader.hasMore()) {
                // 表示文档结束
                return new Token(TokenType.END_DOCUMENT, null);
            }
            // 未结束，就读取下一个字符
            c = charReader.next();
            // 判断是否为空白字符
        } while (tokenHelper.isWhiteSpace(c));

        return tokenHelper.createToken(c);
    }


}
