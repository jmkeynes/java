package com.learn.shop.dto.pms;

import com.learn.shop.pojo.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 11:32
 * @ClassName BrandQueryParam
 */
@Setter
@Getter
public class BrandQueryParam extends PageRequest implements Serializable {

    private String keyword;
}
