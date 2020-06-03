package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.CouponDao;
import com.learn.shop.entity.sms.CouponEntity;
import com.learn.shop.service.sms.ICouponService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠卷表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements ICouponService {

}
