package org.hotilsframework.json.tokenizer;

import org.hotilsframework.json.exception.JsonParseException;

import java.io.IOException;

/**
 * 存储对应类型和字面量的标记类的工具类
 *
 * @Author: hireny
 * @Date: Create in 2019/07/17 11:20
 */
public class TokenHelper {
    
    public CharReader charReader;

    public TokenHelper(CharReader charReader) {
        this.charReader = charReader;
    }

    public Token createToken(char c) throws IOException, JsonParseException {

        String value = String.valueOf(c);

        switch (c) {
            case '{':
                return new Token(TokenType.BEGIN_OBJECT, value);
            case '}':
                return new Token(TokenType.END_OBJECT, value);
            case '[':
                return new Token(TokenType.BEGIN_ARRAY, value);
            case ']':
                return new Token(TokenType.END_ARRAY, value);
            case ',':
                return new Token(TokenType.SEP_COMMA, value);
            case ':':
                return new Token(TokenType.SEP_COLON, value);
            case 'n':
                return readNull();
            case 't':
            case 'f':
                return readBoolean();
            case '"':
                return readString();
            case '-':
                return readNumber();
        }

        if (isDigit(c)) {
            return readNumber();
        }

        throw new JsonParseException("Illegal character");
    }

    /*       以下方法用来判断所属数据类型是否合法          */

    /**
     * 判断一个字符是否属于空白字符
     * @param c
     * @return
     */
    public boolean isWhiteSpace(char c) {
        return (c == ' ' || c == '\t' || c == '\r' || c == '\n');
    }

    /**
     * 判断是否有乱传转义字符
     * @return
     * @throws IOException
     */
    private boolean isEscape() throws IOException {
        char c = charReader.next();
        return (c == '"' || c == '\\' || c == 'u' || c == 'r'
                || c == 'n' || c == 'b' || c == 't' || c == 'f' || c == '/');
    }

    /**
     * 判断是否是十六进制
     * @param c
     * @return
     */
    public boolean isHex(char c) {
        return ((c >= '0' && c <= '9') || ('a' <= c && c <= 'f')
                || ('A' <= c && c <= 'F'));
    }

    /**
     * 判断是否是指数
     * @param c
     * @return
     * @throws IOException
     */
    public boolean isExp(char c) throws IOException {
        return c == 'e' || c == 'E';
    }

    /**
     * 判断数字范围[0,9]
     * @param ch
     * @return
     */
    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 判断数字范围[1,9]
     * @param ch
     * @return
     */
    public boolean isDigitOneToNine(char ch) {
        return ch >= '1' && ch <= '9';
    }


    /**
     * 判断是否为字符串
     * @return
     * @throws IOException
     */
    private Token readString() throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder();
        while(true) {
            char ch = charReader.next();
            if (ch == '\\') {   // 处理转义字符
                if (!isEscape()) {
                    throw new JsonParseException("Invalid escape character");
                }
                sb.append('\\');
                ch = charReader.peek();
                sb.append(ch);
                if (ch == 'u') {   // 处理 Unicode 编码，形如 \u4e2d。且只支持 \u0000 ~ \uFFFF 范围内的编码
                    for (int i = 0; i < 4; i++) {
                        ch = charReader.next();
                        if (isHex(ch)) {
                            sb.append(ch);
                        } else {
                            throw new JsonParseException("Invalid character");
                        }
                    }
                }
            } else if (ch == '"') {     // 碰到另一个双引号，则认为字符串解析结束，返回 Token
                return new Token(TokenType.STRING, sb.toString());
            } else if (ch == '\r' || ch == '\n') {     // 传入的 JSON 字符串不允许换行
                throw new JsonParseException("Invalid character");
            } else {
                sb.append(ch);
            }
        }
    }

    /**
     * 判断是否是整数
     * @return
     * @throws IOException
     */
    public Token readNumber() throws IOException, JsonParseException {
        char ch = charReader.peek();
        StringBuilder sb = new StringBuilder();
        if (ch == '-') {    // 处理负数
            sb.append(ch);
            ch = charReader.next();
            if (ch == '0') {    // 处理 -0.xxxx
                sb.append(ch);
                sb.append(readFracAndExp());
            } else if (isDigitOneToNine(ch)) {
                do {
                    sb.append(ch);
                    ch = charReader.next();
                } while (isDigit(ch));
                if (ch != (char) -1) {
                    charReader.back();
                    sb.append(readFracAndExp());
                }
            } else {
                throw new JsonParseException("Invalid minus number");
            }
        } else if (ch == '0') {    // 处理小数
            sb.append(ch);
            sb.append(readFracAndExp());
        } else {
            do {
                sb.append(ch);
                ch = charReader.next();
            } while (isDigit(ch));
            if (ch != (char) -1) {
                charReader.back();
                sb.append(readFracAndExp());
            }
        }

        return new Token(TokenType.NUMBER, sb.toString());
    }

    public String readFracAndExp() throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder();
        char ch = charReader.next();
        if (ch ==  '.') {
            sb.append(ch);
            ch = charReader.next();
            if (!isDigit(ch)) {
                throw new JsonParseException("Invalid frac");
            }
            do {
                sb.append(ch);
                ch = charReader.next();
            } while (isDigit(ch));

            if (isExp(ch)) {    // 处理科学计数法
                sb.append(ch);
                sb.append(readExp());
            } else {
                if (ch != (char) -1) {
                    charReader.back();
                }
            }
        } else if (isExp(ch)) {
            sb.append(ch);
            sb.append(readExp());
        } else {
            charReader.back();
        }

        return sb.toString();
    }

    /**
     * 处理指数形式的数据
     * @return
     * @throws IOException
     */
    public String readExp() throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder();
        char ch = charReader.next();
        if (ch == '+' || ch =='-') {
            sb.append(ch);
            ch = charReader.next();
            if (isDigit(ch)) {
                do {
                    sb.append(ch);
                    ch = charReader.next();
                } while (isDigit(ch));

                if (ch != (char) -1) {    // 读取结束，不用回退
                    charReader.back();
                }
            } else {
                throw new JsonParseException("e or E");
            }
        } else {
            throw new JsonParseException("e or E");
        }

        return sb.toString();
    }

    /**
     * 判断是否是true or false
     * @return
     * @throws IOException
     */
    public Token readBoolean() throws IOException, JsonParseException {
        if (charReader.peek() == 't') {
            if (!(charReader.next() == 'r' && charReader.next() == 'u' && charReader.next() == 'e')) {
                throw new JsonParseException("Invalid json string");
            }

            return new Token(TokenType.BOOLEAN, "true");
        } else {
            if (!(charReader.next() == 'a' && charReader.next() == 'l'
                    && charReader.next() == 's' && charReader.next() == 'e')) {
                throw new JsonParseException("Invalid json string");
            }

            return new Token(TokenType.BOOLEAN, "false");
        }
    }

    /**
     * 词法分析器在读取字符n后，期望后面的三个字符分别是u,l,l，与 n 组成词 null。
     * 如果满足期望，则返回类型为 NULL 的 Token，否则报异常。
     * @return
     * @throws IOException
     */
    private Token readNull() throws IOException, JsonParseException {
        if (!(charReader.next() == 'u' && charReader.next() == 'l' && charReader.next() == 'l')) {
            throw new JsonParseException("Invalid json string");
        }

        return new Token(TokenType.NULL, "null");
    }
}
