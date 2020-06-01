package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.product.ProductFullReductionDao;
import com.learn.shop.entity.product.ProductFullReductionEntity;
import com.learn.shop.service.product.IProductFullReductionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品满减表(只针对同商品) 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductFullReductionServiceImpl extends ServiceImpl<ProductFullReductionDao, ProductFullReductionEntity> implements IProductFullReductionService {

}
