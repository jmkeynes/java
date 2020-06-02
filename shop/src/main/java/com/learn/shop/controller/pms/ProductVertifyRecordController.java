package com.learn.shop.controller.pms;


import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductVertifyRecordService;
import com.learn.shop.vo.pms.ProductVertifyRecordInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品审核记录 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/pms-product-vertify-record")
@Api(tags = "商品审核记录 前端控制器")
public class ProductVertifyRecordController {

    @Resource
    private IProductVertifyRecordService productVertifyRecordService;

    @PostMapping("/getVertifyByProductId")
    @ApiOperation("根据商品id查询商品审核记录")
    public ResultBean<ProductVertifyRecordInfoVo> getVertifyByProductId(Long productId){
        return this.productVertifyRecordService.getVertifyByProductId(productId);
    }

}

