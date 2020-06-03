package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.HomeNewProductQueryParam;
import com.learn.shop.entity.sms.HomeNewProductEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeNewProductService;
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
 * 新鲜好物表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "新鲜好物表 前端控制器")
@RestController
@RequestMapping("/sms-home-new-product-entity")
public class HomeNewProductController {

    @Resource
    private IHomeNewProductService homeNewProductService;

    @PostMapping("/getPageHomeNewProductList")
    @ApiOperation("新品推荐分页查询列表")
    public ResultBean<IPage<HomeNewProductEntity>> getPageHomeNewProductList(HomeNewProductQueryParam param) {
        return this.homeNewProductService.getPageHomeNewProductList(param);
    }

    @PostMapping("/updateHomeNewProduct")
    @ApiOperation("新品推荐更新")
    public ResultBean<Boolean> updateHomeNewProduct(HomeNewProductEntity entity) {
        return ResultBean.success(this.homeNewProductService.updateById(entity));
    }

    @PostMapping("/batchUpdateHomeNewProduct")
    @ApiOperation("批量更新")
    public ResultBean<Boolean> batchUpdateHomeNewProduct(List<HomeNewProductEntity> entities) {
        return ResultBean.success(this.homeNewProductService.updateBatchById(entities));
    }

    @DeleteMapping("/deleteHomeNewProductById")
    @ApiOperation("删除")
    public ResultBean<Boolean> deleteHomeNewProductById(Long id) {
        return ResultBean.success(this.homeNewProductService.removeById(id));
    }

    @DeleteMapping("/batchDeleteHomeNewProduct")
    @ApiOperation("批量删除")
    public ResultBean<Boolean> batchDeleteHomeNewProduct(List<HomeNewProductEntity> entities) {
        return ResultBean.success(this.homeNewProductService.removeByIds(entities));
    }

}

