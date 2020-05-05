package com.learn.oss.pojo.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author：江文谱
 * @date： 2020/5/5 16:09
 * @version： 1.0
 */
@Setter
@Getter
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "执行成功", data);
    }
}
