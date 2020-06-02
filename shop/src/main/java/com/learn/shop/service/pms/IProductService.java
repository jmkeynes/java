package com.learn.shop.service.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.pms.ProductDto;
import com.learn.shop.dto.pms.ProductQueryParam;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.pms.ProductListVo;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IProductService extends IService<ProductEntity> {


    /**
     * 商品信息分页
     *
     * @param param 分页条件查询
     * @author jwp
     * @date 2020-6-2
     */
    ResultBean<IPage<ProductListVo>> getPageProductInfo(ProductQueryParam param);

    /**
     * 商品添加
     * @author jwp
     * @date 2020-6-2
     * @param productDto 商品DTO
     */
    ResultBean<Boolean> addProduct(ProductDto productDto);
}
