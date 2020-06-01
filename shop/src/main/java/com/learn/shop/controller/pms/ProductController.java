package com.learn.shop.controller.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.pojo.request.PageRequest;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/pms-product")
@Api(tags = "商品信息 前端控制器")
public class ProductController {

    @Resource
    private IProductService productService;

    @GetMapping("/getPageProductInfo")
    @ApiOperation(value = "商品分页")
    public ResultBean<IPage<ProductEntity>> getPageProductInfo(PageRequest pageRequest){
        return this.productService.getPageProductInfo(pageRequest);
    }

}

