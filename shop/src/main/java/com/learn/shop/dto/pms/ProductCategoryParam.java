package com.learn.shop.dto.pms;

import com.learn.shop.pojo.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/6 0:59
 * @ClassName ProductCategoryDto
 */
@Setter
@Getter
public class ProductCategoryParam extends PageRequest {

    private Long parentId;
}
