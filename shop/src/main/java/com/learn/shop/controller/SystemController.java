package com.learn.shop.controller;

import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/14 22:22
 * @ClassName SystemController
 */
@Api(tags = "系统初始化")
@RestController("/sys-init")
public class SystemController {

    @Resource
    private IProductService productService;

    @ApiOperation("初始化热销商品信息进入缓存")
    @PostMapping("/initRedisHotProduct")
    public ResultBean<Boolean> initRedisHotProduct(){
        return productService.initHotProductToRedisData();
    }

    @ApiOperation("初始化热销商品信息进入搜索库")
    @PostMapping("/initProductToSolrData")
    public ResultBean<Boolean> initProductToSolrData(){
        return this.productService.initProductToSolrData();
    }
}
