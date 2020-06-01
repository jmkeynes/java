package com.learn.shop.dao.product;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.shop.entity.product.ProductCategoryAttributeRelationEntity;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface ProductCategoryAttributeRelationDao extends BaseMapper<ProductCategoryAttributeRelationEntity> {

}
