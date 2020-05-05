package com.learn.elasticsearch.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author：江文谱
 * @date： 2020/5/4 16:29
 * @version： 1.0
 */
@Setter
@Getter
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "执行成功！！！", data);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<>(500, "执行失败！！！", data);
    }
}
