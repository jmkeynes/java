package com.learn.shop.service.impl.product;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductOperateLogDao;
import com.learn.shop.entity.pms.ProductOperateLogEntity;
import com.learn.shop.service.product.IProductOperateLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductOperateLogServiceImpl extends ServiceImpl<ProductOperateLogDao, ProductOperateLogEntity> implements IProductOperateLogService {

}
