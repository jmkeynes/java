package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.product.ProductCategoryAttributeRelationDao;
import com.learn.shop.entity.product.ProductCategoryAttributeRelationEntity;
import com.learn.shop.service.product.IProductCategoryAttributeRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductCategoryAttributeRelationServiceImpl extends ServiceImpl<ProductCategoryAttributeRelationDao, ProductCategoryAttributeRelationEntity> implements IProductCategoryAttributeRelationService {

}
