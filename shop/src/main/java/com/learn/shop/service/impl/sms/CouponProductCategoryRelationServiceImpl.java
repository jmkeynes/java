package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.CouponProductCategoryRelationDao;
import com.learn.shop.entity.sms.CouponProductCategoryRelationEntity;
import com.learn.shop.service.sms.ICouponProductCategoryRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券和产品分类关系表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class CouponProductCategoryRelationServiceImpl extends ServiceImpl<CouponProductCategoryRelationDao, CouponProductCategoryRelationEntity> implements ICouponProductCategoryRelationService {

}
