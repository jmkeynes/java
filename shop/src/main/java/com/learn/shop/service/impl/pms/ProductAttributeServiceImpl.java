package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductAttributeDao;
import com.learn.shop.entity.pms.ProductAttributeEntity;
import com.learn.shop.service.pms.IProductAttributeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeDao, ProductAttributeEntity> implements IProductAttributeService {

}
