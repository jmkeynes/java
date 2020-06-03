package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.CouponProductRelationDao;
import com.learn.shop.entity.sms.CouponProductRelationEntity;
import com.learn.shop.service.sms.ICouponProductRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券和产品的关系表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class CouponProductRelationServiceImpl extends ServiceImpl<CouponProductRelationDao, CouponProductRelationEntity> implements ICouponProductRelationService {

}
