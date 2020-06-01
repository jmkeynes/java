package com.learn.shop.service.pms;


import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.ProductCategoryAttributeRelationEntity;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IProductCategoryAttributeRelationService extends IService<ProductCategoryAttributeRelationEntity> {

}
