package com.learn.shop.controller.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.controller.BaseController;
import com.learn.shop.entity.pms.ProductAttributeCategoryEntity;
import com.learn.shop.pojo.request.PageRequest;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "产品属性分类表 前端控制器")
@Controller
@RequestMapping("/pms-product-attribute-category")
public class ProductAttributeCategoryController extends BaseController {

    @Resource
    private IProductAttributeCategoryService productAttributeCategoryService;

    @ApiOperation("产品属性分类路由")
    @GetMapping("/gotoProductAttributeCategory")
    public String gotoProductAttributeCategory() {
        return "pms/product_attribute_category";
    }

    /**
     * 产品属性分类  分页
     *
     * @param pageRequest 分页参数
     * @author jwp
     * @date 2020-6-6
     */
    @ApiOperation("产品属性分类  分页")
    @PostMapping("/getPageProductAttributeCategory")
    @ResponseBody
    public Map getPageProductAttributeCategory(PageRequest pageRequest) {
        ResultBean<IPage<ProductAttributeCategoryEntity>> bean = this.productAttributeCategoryService.getPageProductAttributeCategory(pageRequest);
        return this.getMap(bean.getData());
    }

}

