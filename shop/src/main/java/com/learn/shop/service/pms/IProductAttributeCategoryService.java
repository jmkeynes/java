package com.learn.shop.service.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.ProductAttributeCategoryEntity;
import com.learn.shop.pojo.request.PageRequest;
import com.learn.shop.pojo.result.ResultBean;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IProductAttributeCategoryService extends IService<ProductAttributeCategoryEntity> {

    /**
     * 产品属性分类 分页
     *
     * @param pageRequest 分页参数
     * @author jwp
     * @date 2020-6-6
     */
    ResultBean<IPage<ProductAttributeCategoryEntity>> getPageProductAttributeCategory(PageRequest pageRequest);
}
