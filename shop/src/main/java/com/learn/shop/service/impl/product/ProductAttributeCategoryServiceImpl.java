package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductAttributeCategoryDao;
import com.learn.shop.entity.pms.ProductAttributeCategoryEntity;
import com.learn.shop.service.product.IProductAttributeCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryDao, ProductAttributeCategoryEntity> implements IProductAttributeCategoryService {

}
