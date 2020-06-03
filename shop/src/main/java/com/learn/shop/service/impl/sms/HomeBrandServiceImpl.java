package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeBrandDao;
import com.learn.shop.entity.sms.HomeBrandEntity;
import com.learn.shop.service.sms.IHomeBrandService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页推荐品牌表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeBrandServiceImpl extends ServiceImpl<HomeBrandDao, HomeBrandEntity> implements IHomeBrandService {

}
