package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.SkuStockDao;
import com.learn.shop.entity.pms.SkuStockEntity;
import com.learn.shop.service.pms.ISkuStockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class SkuStockServiceImpl extends ServiceImpl<SkuStockDao, SkuStockEntity> implements ISkuStockService {

}
