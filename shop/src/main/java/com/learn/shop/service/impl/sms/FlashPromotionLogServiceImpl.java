package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.FlashPromotionLogDao;
import com.learn.shop.entity.sms.FlashPromotionLogEntity;
import com.learn.shop.service.sms.IFlashPromotionLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 限时购通知记录 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class FlashPromotionLogServiceImpl extends ServiceImpl<FlashPromotionLogDao, FlashPromotionLogEntity> implements IFlashPromotionLogService {

}
