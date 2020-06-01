package com.learn.shop.service.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.pojo.request.PageRequest;
import com.learn.shop.pojo.result.ResultBean;

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
     * @param pageRequest 查询分页
     */
    ResultBean<IPage<ProductEntity>> getPageProductInfo(PageRequest pageRequest);
}
