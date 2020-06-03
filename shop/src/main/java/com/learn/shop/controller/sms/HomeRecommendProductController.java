package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.HomeNewProductQueryParam;
import com.learn.shop.entity.sms.HomeRecommendProductEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeRecommendProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 人气推荐商品表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "人气推荐商品表 前端控制器")
@RestController
@RequestMapping("/sms-home-recommend-product-entity")
public class HomeRecommendProductController {

    @Resource
    private IHomeRecommendProductService homeRecommendProductService;

    @PostMapping("/getPageHomeRecommendProductList")
    @ApiOperation("新品推荐分页查询列表")
    public ResultBean<IPage<HomeRecommendProductEntity>> getPageHomeRecommendProductList(HomeNewProductQueryParam param) {
        return this.homeRecommendProductService.getPageHomeNewProductList(param);
    }

    @PostMapping("/updateHomeRecommendProduct")
    @ApiOperation("新品推荐更新")
    public ResultBean<Boolean> updateHomeRecommendProduct(HomeRecommendProductEntity entity) {
        return ResultBean.success(this.homeRecommendProductService.updateById(entity));
    }

    @PostMapping("/batchUpdateHomeRecommendProduct")
    @ApiOperation("批量更新")
    public ResultBean<Boolean> batchUpdateHomeRecommendProduct(List<HomeRecommendProductEntity> entities) {
        return ResultBean.success(this.homeRecommendProductService.updateBatchById(entities));
    }

    @DeleteMapping("/deleteHomeHomeRecommendProductById")
    @ApiOperation("删除")
    public ResultBean<Boolean> deleteHomeHomeRecommendProductById(Long id) {
        return ResultBean.success(this.homeRecommendProductService.removeById(id));
    }

    @DeleteMapping("/batchDeleteHomeRecommendProduct")
    @ApiOperation("批量删除")
    public ResultBean<Boolean> batchDeleteHomeRecommendProduct(List<HomeRecommendProductEntity> entities) {
        return ResultBean.success(this.homeRecommendProductService.removeByIds(entities));
    }

}

