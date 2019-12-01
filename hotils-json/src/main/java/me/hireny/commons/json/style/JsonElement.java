package me.hireny.commons.json.style;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Json的元素抽象类，封装子类的一些方法
 * @Author: hireny
 * @Date: Create in 2019/07/22 10:50
 */
public abstract class JsonElement {

    /**
     * 深拷贝
     * @return
     */
    public abstract JsonElement deepCopy();

    /**
     * provides check for verifying if this element is an array or not.
     * 提供检查以验证该元素是否是数组
     * @return
     */
    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    /**
     * provides check for verifying if this element is a Json object or not.
     * 提供检查以验证该元素是否是Json对象
     * @return
     */
    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    /**
     * provides check for verifying if this element is a primitive or not.
     * 提供检查以验证该元素是否为基础元素
     * @return
     */
    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    /**
     * provides check for verifying if this element represents a null value or not.
     * 提供检查以验证该元素是否表示空值.
     * @return
     */
    public boolean isJsonNull() {
       return this instanceof JsonNull;
    }


    public JsonObject getJsonObject() {
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public JsonArray getJsonArray() {
        if (isJsonArray()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public JsonPrimitive getJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public JsonNull getJsonNull() {
        if (isJsonNull()) {
            return (JsonNull) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public boolean getBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char getCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigDecimal getBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }
}
