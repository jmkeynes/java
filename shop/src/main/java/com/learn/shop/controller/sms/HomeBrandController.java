package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.BrandRecommendQueryParam;
import com.learn.shop.entity.sms.HomeBrandEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeBrandService;
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
 * 首页推荐品牌表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "首页推荐品牌表 前端控制器")
@RestController
@RequestMapping("/sms-home-brand-entity")
public class HomeBrandController {

    @Resource
    private IHomeBrandService homeBrandService;

    @ApiOperation("推荐品牌分页列表")
    @PostMapping("/getBrandRecommend")
    public ResultBean<IPage<HomeBrandEntity>> getBrandRecommend(BrandRecommendQueryParam param) {
        return this.homeBrandService.getBrandRecommend(param);
    }

    @PostMapping("/updateBrandRecommend")
    @ApiOperation("推荐品牌更新")
    public ResultBean<Boolean> updateBrandRecommend(HomeBrandEntity entity) {
        return ResultBean.success(this.homeBrandService.updateById(entity));
    }

    @PostMapping("/batchUpdateBrandRecommend")
    @ApiOperation("推荐批量更新")
    public ResultBean<Boolean> batchUpdateBrandRecommend(List<HomeBrandEntity> entities) {
        return ResultBean.success(this.homeBrandService.updateBatchById(entities));
    }

    @DeleteMapping("/deleteBrandRecommend")
    @ApiOperation("删除推荐")
    public ResultBean<Boolean> deleteBrandRecommend(Long id) {
        return ResultBean.success(this.homeBrandService.removeById(id));
    }

    @DeleteMapping("/batchDeleteBrandRecommend")
    @ApiOperation("批量删除推荐")
    public ResultBean<Boolean> batchDeleteBrandRecommend(List<HomeBrandEntity> entities) {
        return ResultBean.success(this.homeBrandService.removeByIds(entities));
    }

}

