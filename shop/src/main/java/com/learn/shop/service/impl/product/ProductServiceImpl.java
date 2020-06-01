package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.product.ProductDao;
import com.learn.shop.entity.product.ProductEntity;
import com.learn.shop.service.product.IProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements IProductService {

}
