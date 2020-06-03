package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeAdvertiseDao;
import com.learn.shop.entity.sms.HomeAdvertiseEntity;
import com.learn.shop.service.sms.IHomeAdvertiseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页轮播广告表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeAdvertiseServiceImpl extends ServiceImpl<HomeAdvertiseDao, HomeAdvertiseEntity> implements IHomeAdvertiseService {

}
