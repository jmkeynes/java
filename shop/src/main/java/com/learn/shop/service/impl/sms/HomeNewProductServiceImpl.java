package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeNewProductDao;
import com.learn.shop.entity.sms.HomeNewProductEntity;
import com.learn.shop.service.sms.IHomeNewProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新鲜好物表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeNewProductServiceImpl extends ServiceImpl<HomeNewProductDao, HomeNewProductEntity> implements IHomeNewProductService {

}
