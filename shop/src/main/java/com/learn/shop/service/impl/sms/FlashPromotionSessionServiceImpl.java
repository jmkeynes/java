package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.FlashPromotionSessionDao;
import com.learn.shop.entity.sms.FlashPromotionSessionEntity;
import com.learn.shop.service.sms.IFlashPromotionSessionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 限时购场次表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class FlashPromotionSessionServiceImpl extends ServiceImpl<FlashPromotionSessionDao, FlashPromotionSessionEntity> implements IFlashPromotionSessionService {

}
