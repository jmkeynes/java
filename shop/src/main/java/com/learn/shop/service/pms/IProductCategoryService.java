package com.learn.shop.service.pms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.ProductCategoryEntity;
import com.learn.shop.pojo.result.ResultBean;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IProductCategoryService extends IService<ProductCategoryEntity> {

    /**
     * 查询父类
     *
     * @param productId 父类id
     * @author jwp
     * @date 2020-6-2
     */
    ResultBean<List<ProductCategoryEntity>> getPageProductCategory(Long productId);

    /**
     * 删除类别
     *
     * @param id 类别id
     * @author jwp
     * @date 2020-6-2
     */
    Boolean deleteProductCategoryById(Long id);

    /**
     * 商品类别修改
     *
     * @param entity 商品实例
     * @author jwp
     * @date 2020-6-2
     */
    ResultBean<Integer> updateProductCategory(ProductCategoryEntity entity);
}
