package me.hireny.commons.core.net.http;

/**
 * @ClassName: ResultGenerator
 * @Author: hireny
 * @Date: Create in 2019/12/24 14:41
 * @Description: TODO   响应结果生成工具
 */
@SuppressWarnings("unchecked")
public final class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result success() {
        return new Result().setCode(1).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>().setCode(1).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static <T> Result<T> success(int code, String message, T data) {
        return new Result<>().setCode(code).setMessage(message).setData(data);
    }

    public static Result failed(String message) {
        return new Result().setCode(-1).setMessage(message);
    }
}
