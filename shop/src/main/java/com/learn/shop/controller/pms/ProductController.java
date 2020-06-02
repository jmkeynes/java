package com.learn.shop.controller.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.pms.ProductQueryParam;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductService;
import com.learn.shop.vo.pms.ProductListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}

