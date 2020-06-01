package com.learn.shop.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.oms.OrderDao;
import com.learn.shop.entity.oms.OrderEntity;
import com.learn.shop.service.oms.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements IOrderService {

}
