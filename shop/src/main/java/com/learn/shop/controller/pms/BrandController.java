package com.learn.shop.controller.pms;


import com.learn.shop.controller.BaseController;
import com.learn.shop.dto.pms.BrandQueryParam;
import com.learn.shop.entity.pms.BrandEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "品牌表 前端控制器")
@Controller
@RequestMapping("/pms-brand")
public class BrandController extends BaseController {

    @Resource
    private IBrandService brandService;

    @GetMapping("/gotoBrand")
    public String gotoBrand(){
        return "pms/brand";
    }
    /**
     * 品牌查询分页列表
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    @PostMapping("/getPageBrandList")
    @ResponseBody
    @ApiOperation("根据关键字/名称 获取品牌分页列表")
    public Map getPageBrandList(BrandQueryParam param) {
        return this.getMap(brandService.getPageBrandList(param).getData());
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
    @ResponseBody
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

