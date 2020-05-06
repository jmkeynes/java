package com.learn.rabbitmq.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author：江文谱
 * @date： 2020/5/5 21:52
 * @version： 1.0
 */
@Setter
@Getter
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result success(T data, String message) {
        return new Result(200, message, data);
    }

    public static Result fialed(int code, String message) {
        return new Result(code, message, null);
    }
}
