package com.learn.shop.controller.pms;


import com.learn.shop.entity.pms.ProductCategoryEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 产品分类 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "产品分类 前端控制器")
@RestController
@RequestMapping("/pms-product-category")
public class ProductCategoryController {

    @Resource
    private IProductCategoryService productCategoryService;

    /**
     * 查询商品分类
     *
     * @param parentId 分类的父id
     * @author jwp
     * @date 2020-6-2
     */
    @ApiOperation("查询商品分类，及下级")
    @GetMapping("/getPageProductCategory")
    public ResultBean<List<ProductCategoryEntity>> getPageProductCategory(Long parentId) {
        return this.productCategoryService.getPageProductCategory(parentId);

    }

    /**
     * 根据商品类别id，删除商品类别
     *
     * @param id id
     * @author jwp
     * @date 2020-6-2
     */
    @ApiOperation("删除商品分类")
    @DeleteMapping("/deleteProductCategoryById")
    public ResultBean<Boolean> deleteProductCategoryById(Long id) {
        return ResultBean.success(this.productCategoryService.deleteProductCategoryById(id));
    }

    /**
     * 修改商品分类
     *
     * @param entity 分类实例
     * @author jwp
     * @date 2020-6-2
     */
    @PostMapping("/updateProductCategory")
    @ApiOperation("修改商品分类")
    public ResultBean<Integer> updateProductCategory(ProductCategoryEntity entity) {
        return this.productCategoryService.updateProductCategory(entity);
    }

}

