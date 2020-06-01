package com.learn.shop.pojo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("返回结果")
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty("状态")
    private Integer code;
    @ApiModelProperty("信息")
    private String message;

    @ApiModelProperty("数据")
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
