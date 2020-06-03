package com.learn.shop.controller.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.pms.BrandQueryParam;
import com.learn.shop.entity.pms.BrandEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IBrandService;
import com.learn.shop.vo.pms.BrandVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "品牌表 前端控制器")
@RestController
@RequestMapping("/pms-brand")
public class BrandController {

    @Resource
    private IBrandService brandService;

    /**
     * 品牌查询分页列表
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    @GetMapping("/getPageBrandList")
    @ApiOperation("根据关键字/名称 获取品牌分页列表")
    public ResultBean<IPage<BrandVo>> getPageBrandList(BrandQueryParam param) {
        return this.brandService.getPageBrandList(param);
    }

    /**
     * 删除
     *
     * @param id 品牌id
     * @author jwp
     * @date 2020-6-3
     */
    @DeleteMapping("/deleteBrandById")
    @ApiOperation("根据id删除品牌id")
    public ResultBean<Boolean> deleteBrandById(Long id) {
        return ResultBean.success(this.brandService.removeById(id));
    }

    /**
     * 编辑品牌详情
     *
     * @param entity 实例详情
     * @author jwp
     * @date 2020-6-3
     */
    @PostMapping("/addOrUpdateBrand")
    @ApiOperation("编辑品牌")
    public ResultBean<Boolean> addOrUpdateBrand(BrandEntity entity) {
        return ResultBean.success(this.brandService.saveOrUpdate(entity));
    }

    /**
     * 根据id查询品牌详情
     *
     * @param id 品牌id
     * @author jwp
     * @date 2020-6-3
     */
    @GetMapping("/getBrandById")
    @ApiOperation(("查询品牌详情"))
    public ResultBean<BrandEntity> getBrandById(Long id) {
        return ResultBean.success(this.brandService.getById(id));
    }

    /**
     * 批量更新品牌详情信息
     *
     * @param entities 实例集合
     * @author jwp
     * @date 2020-6-3
     */
    @PostMapping("/batchUpdateBrand")
    @ApiOperation("批量更新品牌详情")
    public ResultBean<Boolean> batchUpdateBrand(List<BrandEntity> entities) {
        return ResultBean.success(this.brandService.updateBatchById(entities));
    }
}

