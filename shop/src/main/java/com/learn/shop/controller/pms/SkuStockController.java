package com.learn.shop.controller.pms;


import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.ISkuStockService;
import com.learn.shop.vo.pms.SkuStockListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * sku的库存 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/pms-sku-stock")
@Api(tags = "sku的库存 前端控制器")
public class SkuStockController {

    @Resource
    private ISkuStockService skuStockService;

    /**
     * 根据id查询库存信息
     *
     * @param productId 商品id
     * @author jwp
     * @date 2020-6-2
     */
    @PostMapping("/getSkuStockByProduct")
    @ApiOperation("根据id查询库存信息")
    public ResultBean<List<SkuStockListVo>> getSkuStockByProduct(Long productId) {
        return skuStockService.getSkuStockByProduct(productId);
    }

    @PostMapping("/getSkuStockBySkuCode")
    @ApiOperation("根据库存编号查询库存信息")
    public ResultBean<SkuStockListVo> getSkuStockBySkuCode(String skuCode){
        return this.skuStockService.getSkuStockBySkuCode(skuCode);
    }

}

