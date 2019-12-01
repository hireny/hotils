package me.hireny.commons.json.parser;


import me.hireny.commons.json.exception.JsonParseException;
import me.hireny.commons.json.style.JsonArray;
import me.hireny.commons.json.style.JsonObject;
import me.hireny.commons.json.tokenizer.Token;
import me.hireny.commons.json.tokenizer.TokenReader;
import me.hireny.commons.json.tokenizer.TokenType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 解析类
 *
 * @Author: hireny
 * @Date: Create in 2019/07/16 20:41
 */
public class JSONParser {

    private static final int BEGIN_OBJECT_TOKEN = 1;
    private static final int END_OBJECT_TOKEN = 2;
    private static final int BEGIN_ARRAY_TOKEN = 4;
    private static final int END_ARRAY_TOKEN = 8;
    private static final int NULL_TOKEN = 16;
    private static final int NUMBER_TOKEN = 32;
    private static final int STRING_TOKEN = 64;
    private static final int BOOLEAN_TOKEN = 128;
    private static final int SEP_COLON_TOKEN = 256;
    private static final int SEP_COMMA_TOKEN = 512;

    private TokenReader tokens;

    public Object parse(TokenReader tokens) throws JsonParseException {
        // 获取所有的token流
        this.tokens = tokens;
        return parse();
    }

    /**
     * 解析
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T> T parse() throws JsonParseException {
        // 开始解析，首先获取tokens流中的第一个Token
        Token token = tokens.next();
        if (token == null) {
            return (T) new JsonObject(new HashMap<>()).toJsonValue();
        } else if (token.getTokenType() == TokenType.BEGIN_OBJECT) {
            return (T) parseJsonObject().toJsonValue();
        } else if (token.getTokenType() == TokenType.BEGIN_ARRAY) {
            return (T) parserJsonArray().toJsonValue();
        }
        throw new JsonParseException("Parse error, invalid Token.(解析错误，无效的Token)");
    }

    private void checkExpectToken(TokenType tokenType, int expectToken) throws JsonParseException {
        if ((tokenType.getTokenCode() & expectToken) == 0) {
            throw new JsonParseException("Parse error, invalid Token.(解析错误，无效的Token)");
        }
    }

    /**
     * 解析Json对象
     * @return
     */
    private JsonObject parseJsonObject() throws JsonParseException {
        JsonObject jsonObject = new JsonObject(new HashMap<>());
        int expectToken = STRING_TOKEN | END_OBJECT_TOKEN;
        String key = null;      // 键
        Object value = null;    // 值
        // 判断token流是否结束
        while (tokens.hasMore()) {
            // 未结束就从token流中读取下一个Token
            Token token = tokens.next();    //该token获取的是"{"之后的对象
            TokenType tokenType = token.getTokenType();
            String tokenValue = token.getValue();
            // 判断token类型
            switch (tokenType) {
                case BEGIN_OBJECT:
                    // 判断是否为 "{"
                    checkExpectToken(tokenType, expectToken);
                    // 递归解析 json object
                    jsonObject.put(key, parseJsonObject());
                    expectToken = SEP_COMMA_TOKEN | END_OBJECT_TOKEN;
                    break;
                case END_OBJECT:
                    // 判断是否为"}"
                    checkExpectToken(tokenType, expectToken);
                    return jsonObject;
                case BEGIN_ARRAY:
                    // 判断是否为"["
                    checkExpectToken(tokenType, expectToken);
                    // 递归解析 json array
                    jsonObject.put(key, parserJsonArray());
                    expectToken = SEP_COMMA_TOKEN | END_OBJECT_TOKEN;
                    break;
                case NULL:
                    // 判断是否为 null
                    checkExpectToken(tokenType, expectToken);
                    jsonObject.put(key, null);
                    expectToken = SEP_COMMA_TOKEN | END_OBJECT_TOKEN;
                    break;
                case NUMBER:
                    // 判断是否为 number 数字
                    checkExpectToken(tokenType, expectToken);
                    // toLowerCase()用于将大写字符转换为小写字符
                    if (tokenValue.contains(".") || tokenValue.toLowerCase().contains("e")) {
                        jsonObject.put(key, Double.valueOf(tokenValue));
                    } else {
                        Long num = Long.valueOf(tokenValue);
                        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
                            jsonObject.put(key, num);
                        } else {
                            jsonObject.put(key, num.intValue());
                        }
                    }
                    expectToken = SEP_COMMA_TOKEN | END_OBJECT_TOKEN;
                    break;
                case BOOLEAN:
                    // 判断是否为 bool
                    checkExpectToken(tokenType, expectToken);
                    jsonObject.put(key, Boolean.valueOf(tokenValue));
                    expectToken = SEP_COMMA_TOKEN | END_OBJECT_TOKEN;
                    break;
                case STRING:
                    // 判断是否为 string 字符串
                    checkExpectToken(tokenType, expectToken);
                    Token preToken = tokens.peekPrevious();
                    /**
                     * 在 JSON 中，字符串既可以作为键，也可以作为值。
                     * 作为键时，只期待下一个Token类型为 SEP_COLON(:)。SEP_COLON（:）
                     * 作为值时，期待下一个Token类型为SEP_COMMA 或 END_OBJECT
                     */
                    if (preToken.getTokenType() == TokenType.SEP_COLON) {
                        value =token.getValue();
                        jsonObject.put(key, value);
                        expectToken = SEP_COMMA_TOKEN | END_OBJECT_TOKEN;
                    } else {
                        key = token.getValue();
                        expectToken = SEP_COLON_TOKEN;
                    }
                    break;
                case SEP_COLON:
                    // 判断是否为 : 冒号字符
                    checkExpectToken(tokenType, expectToken);
                    expectToken = NULL_TOKEN | NUMBER_TOKEN | BOOLEAN_TOKEN
                            | STRING_TOKEN | BEGIN_OBJECT_TOKEN | BEGIN_ARRAY_TOKEN;
                    break;
                case SEP_COMMA:
                    // 判断是否为 , 分号字符
                    checkExpectToken(tokenType, expectToken);
                    expectToken = STRING_TOKEN;
                    break;
                case END_DOCUMENT:
                    // 判断是否JSON文档结束
                    checkExpectToken(tokenType, expectToken);
                    return jsonObject;
                default:
                    throw new JsonParseException("Unexpected Token.(意想不到的Token)");
            }
        }
        throw new JsonParseException("Parse error, invalid Token.(解析错误，无效的Token)");
    }

    /**
     * 解析Json数组
     * @return
     */
    private JsonArray parserJsonArray() throws JsonParseException {
        JsonArray jsonArray = new JsonArray(new ArrayList<>());
        int expectToken = BEGIN_ARRAY_TOKEN | END_ARRAY_TOKEN | BEGIN_OBJECT_TOKEN
                | NULL_TOKEN | NUMBER_TOKEN | BOOLEAN_TOKEN | STRING_TOKEN;
        while (tokens.hasMore()) {
            Token token = tokens.next();
            TokenType tokenType = token.getTokenType();
            String tokenValue = token.getValue();
            switch (tokenType) {
                case BEGIN_OBJECT:
                    // 判断是否为 "{"
                    checkExpectToken(tokenType, expectToken);
                    jsonArray.add(parseJsonObject());
                    expectToken = SEP_COMMA_TOKEN | END_ARRAY_TOKEN;
                    break;
                case BEGIN_ARRAY:
                    // 判断是否为"["
                    checkExpectToken(tokenType, expectToken);
                    jsonArray.add(parserJsonArray());
                    expectToken = SEP_COMMA_TOKEN | END_ARRAY_TOKEN;
                    break;
                case END_ARRAY:
                    // 判断是否为"]"
                    checkExpectToken(tokenType, expectToken);
                    return jsonArray;
                case NULL:
                    // 判断是否为 null
                    checkExpectToken(tokenType, expectToken);
                    jsonArray.add(null);
                    expectToken = SEP_COMMA_TOKEN | END_ARRAY_TOKEN;
                    break;
                case NUMBER:
                    // 判断是否为 number 数字
                    checkExpectToken(tokenType, expectToken);
                    if (tokenValue.contains(".") || tokenValue.toLowerCase().contains("e")) {
                        jsonArray.add(Double.valueOf(tokenValue));
                    } else {
                        Long num = Long.valueOf(tokenValue);
                        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
                            jsonArray.add(num);
                        } else {
                            jsonArray.add(num.intValue());
                        }
                    }
                    expectToken = SEP_COMMA_TOKEN | END_ARRAY_TOKEN;
                    break;
                case BOOLEAN:
                    // 判断是否为 boolean
                    checkExpectToken(tokenType, expectToken);
                    jsonArray.add(Boolean.valueOf(tokenValue));
                    expectToken = SEP_COMMA_TOKEN | END_ARRAY_TOKEN;
                    break;
                case STRING:
                    // 判断是否为 string 字符串
                    checkExpectToken(tokenType,expectToken);
                    jsonArray.add(tokenValue);
                    expectToken = SEP_COMMA_TOKEN | END_ARRAY_TOKEN;
                    break;
                case SEP_COMMA:
                    // 判断是否为 , 分号字符
                    checkExpectToken(tokenType, expectToken);
                    expectToken = STRING_TOKEN | NULL_TOKEN | NUMBER_TOKEN
                            | BOOLEAN_TOKEN | BEGIN_ARRAY_TOKEN | BEGIN_OBJECT_TOKEN;
                    break;
                case END_DOCUMENT:
                    // 判断是否JSON文档结束
                    checkExpectToken(tokenType, expectToken);
                    return jsonArray;
                default:
                    throw new JsonParseException("Unexpected Token.(意想不到的Token)");
            }
        }
        throw new JsonParseException("Parse error, invalid Token.(解析错误，无效Token)");
    }

}
