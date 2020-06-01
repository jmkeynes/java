package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductLadderDao;
import com.learn.shop.entity.pms.ProductLadderEntity;
import com.learn.shop.service.pms.IProductLadderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductLadderServiceImpl extends ServiceImpl<ProductLadderDao, ProductLadderEntity> implements IProductLadderService {

}
