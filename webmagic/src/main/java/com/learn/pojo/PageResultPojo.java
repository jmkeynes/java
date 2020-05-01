package com.learn.pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:14
 * 版本： 1.0
 */
@Data
public class PageResultPojo<T> implements Serializable {

    private Long total;

    private Page page;

    private List<T> rows;
}
