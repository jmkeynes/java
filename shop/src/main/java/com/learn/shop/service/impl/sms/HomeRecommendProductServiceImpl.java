package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeRecommendProductDao;
import com.learn.shop.entity.sms.HomeRecommendProductEntity;
import com.learn.shop.service.sms.IHomeRecommendProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人气推荐商品表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeRecommendProductServiceImpl extends ServiceImpl<HomeRecommendProductDao, HomeRecommendProductEntity> implements IHomeRecommendProductService {

}
