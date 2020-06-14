package com.learn.shop.controller.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.controller.BaseController;
import com.learn.shop.dto.pms.ProductCategoryParam;
import com.learn.shop.entity.pms.ProductCategoryEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 产品分类 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "产品分类 前端控制器")
@Controller
@RequestMapping("/pms-product-category")
public class ProductCategoryController extends BaseController {

    @Resource
    private IProductCategoryService productCategoryService;

    @GetMapping("gotoProductCategory")
    public String gotoProductCategory(){
        return "pms/product_category";
    }

    /**
     * 查询商品分类
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-2
     */
    @ApiOperation("查询商品分类，及下级")
    @PostMapping("/getPageProductCategory")
    @ResponseBody
    public Map getPageProductCategory(ProductCategoryParam param) {
        ResultBean<IPage<ProductCategoryEntity>> pageProductCategory = this.productCategoryService.getPageProductCategory(param);
        return this.getMap(pageProductCategory.getData());

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

