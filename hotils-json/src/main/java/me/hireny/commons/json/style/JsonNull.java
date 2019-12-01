package me.hireny.commons.json.style;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/22 21:54
 */
public class JsonNull extends JsonElement {
    @Override
    public JsonElement deepCopy() {
        return null;
    }
}
