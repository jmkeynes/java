package com.learn.shop.controller.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.pms.ProductDto;
import com.learn.shop.dto.pms.ProductQueryParam;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductService;
import com.learn.shop.vo.pms.ProductListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/pms-product")
@Api(tags = "商品信息 前端控制器")
public class ProductController {

    @Resource
    private IProductService productService;

    /**
     * 商品分页查询
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-2
     */
    @GetMapping("/getPageProductInfo")
    @ApiOperation(value = "商品分页查询")
    public ResultBean<IPage<ProductListVo>> getPageProductInfo(ProductQueryParam param) {
        return this.productService.getPageProductInfo(param);
    }

    /**
     * 根据id删除商品
     *
     * @param id 商品id
     * @author jwp
     * @date 2020-6-2
     */
    @DeleteMapping("/deleteProductById")
    @ApiOperation(("根据id删除商品"))
    public ResultBean<Boolean> deleteProductById(Long id) {
        return ResultBean.success(this.productService.removeById(id));
    }

    /**
     * 商品批量更新操作
     *
     * @param entities 商品集合
     * @author jwp
     * @date 2020-6-2
     */
    @PostMapping("/updateProduct")
    @ApiOperation("商品批量更新操作")
    public ResultBean<Boolean> updateProduct(List<ProductEntity> entities) {
        return ResultBean.success(this.productService.updateBatchById(entities));
    }

    /**
     * 商品详情
     *
     * @param id 商品id
     * @author jwp
     * @date 2020-6-2
     */
    @PostMapping("/getByProductId")
    @ApiOperation("商品详情查询")
    public ResultBean<ProductEntity> getByProductId(Long id) {
        return ResultBean.success(this.productService.getById(id));
    }

    /**
     * 商品添加
     *
     * @param productDto 商品DTO
     * @author jwp
     * @date 2020-6-2
     */
    @PostMapping("/addProduct")
    @ApiOperation("商品添加")
    public ResultBean<Boolean> addProduct(ProductDto productDto) {
        return this.productService.addProduct(productDto);
    }

}

