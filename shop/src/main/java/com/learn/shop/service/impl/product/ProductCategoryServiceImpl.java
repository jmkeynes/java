package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductCategoryDao;
import com.learn.shop.entity.pms.ProductCategoryEntity;
import com.learn.shop.service.product.IProductCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategoryEntity> implements IProductCategoryService {

}
