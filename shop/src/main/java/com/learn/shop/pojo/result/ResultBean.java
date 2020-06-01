package com.learn.shop.pojo.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 22:26
 * @ClassName ResultBean
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer code;
    private String message;
    private T data;

    public static <T> ResultBean<T> success(Integer code, String message, T data) {
        return new ResultBean<>(code, message, data);
    }

    public static <T> ResultBean<T> success(String message, T data) {
        return new ResultBean<>(200, message, data);
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(200, "成功！！", data);
    }

}
