package me.hireny.commons.core.net.http;

/**
 * @ClassName: Result
 * @Author: hireny
 * @Date: Create in 2019/12/24 14:37
 * @Description: TODO   统一API响应结果封装
 */
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
