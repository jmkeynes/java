package com.learn.shop.vo.pms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 14:02
 * @ClassName ProductInfoVo
 */
@Setter
@Getter
public class ProductInfoVo implements Serializable {

    /**
     * 商品序号
     */
    private Long id;
}
