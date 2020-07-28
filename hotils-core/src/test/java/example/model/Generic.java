package example.model;

/**
 * Generic
 * 类描述
 *
 * @author hireny
 * @create 2020-07-28 21:57
 */
public class Generic<T> {
    private T value;

    public Generic(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Generic{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
