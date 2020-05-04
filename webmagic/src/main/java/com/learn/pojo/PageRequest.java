package com.learn.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 创建人：江文谱
 * 创建时间： 2020/5/1 11:48
 * 版本： 1.0
 */
@Setter
@Getter
@ApiModel("分页请求参数")
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -6878053406541100993L;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private int page = 1;

    /**
     * 分页数量 默认10条
     */
    @ApiModelProperty(value = "分页数量 默认10条")
    private int limit = 10;

    /**
     * 排序规则
     */
    @ApiModelProperty(value = "排序规则")
    private String orderByColum;

    /**
     * 排序方式     升序或者倒序
     */
    @ApiModelProperty(value = "排序方式     升序或者倒序")
    private String isAsc;

}
