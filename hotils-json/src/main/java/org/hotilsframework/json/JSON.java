package org.hotilsframework.json;


import org.hotilsframework.json.exception.JsonParseException;
import org.hotilsframework.json.parser.JSONParser;
import org.hotilsframework.json.tokenizer.CharReader;
import org.hotilsframework.json.tokenizer.TokenReader;
import org.hotilsframework.json.tokenizer.Tokenizer;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/11 13:18
 * @Description: TODO
 */
public class JSON {

    private Tokenizer tokenizer = new Tokenizer();
//
    private JSONParser jSONParser = new JSONParser();

    /**
     * JSON字符串转换为JSON对象
     * @param s
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public <T> T fromJSON(String s) throws IOException, JsonParseException {
        // 字符串读取
        StringReader stringReader = new StringReader(s);
        CharReader charReader = new CharReader(stringReader);
        TokenReader tokens = tokenizer.getTokenStream(charReader);
        return (T) jSONParser.parse(tokens);
    }

//    public <T> T fromJSON(String s, Class<?> classTarget) throws IOException, JsonParseException {
//        Map map = fromJSON(s);
//
//        return null;
//    }

    /**
     * JSON对象转换为JSON字符串
     * @param o
     * @return
     * @throws IOException
     */
    public String toJSON(Object o) throws IOException {
//        if (o == null) {
//            return toJSON(JsonNull.INSTANCE);
//        }
        return toJSON(o, o.getClass());

//        if (o instanceof Map) {
//            Map<Object, Object> map = (Map<Object, Object>) o;
//            int size = map.size();
//
//        }

//        return o.toString();
    }
    public String toJSON(Object o, Type type) {
        StringWriter writer = new StringWriter();
        toJSON(o, type, writer);
        return writer.toString();
    }

    public String toJSON(Object o, Type type, Appendable writer) {
        return null;
    }
}
