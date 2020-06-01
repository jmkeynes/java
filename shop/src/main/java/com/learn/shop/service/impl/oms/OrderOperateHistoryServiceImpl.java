package com.learn.shop.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.oms.OrderOperateHistoryDao;
import com.learn.shop.entity.oms.OrderOperateHistoryEntity;
import com.learn.shop.service.oms.IOrderOperateHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单操作历史记录 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryDao, OrderOperateHistoryEntity> implements IOrderOperateHistoryService {

}
