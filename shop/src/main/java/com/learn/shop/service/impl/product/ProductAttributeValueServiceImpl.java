package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductAttributeValueDao;
import com.learn.shop.entity.pms.ProductAttributeValueEntity;
import com.learn.shop.service.product.IProductAttributeValueService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储产品参数信息的表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductAttributeValueServiceImpl extends ServiceImpl<ProductAttributeValueDao, ProductAttributeValueEntity> implements IProductAttributeValueService {

}
