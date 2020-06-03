package com.learn.shop.service.oms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.oms.OrderQueryParam;
import com.learn.shop.entity.oms.OrderEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.oms.OrderListVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IOrderService extends IService<OrderEntity> {

    /**
     * 订单分页查询
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    ResultBean<IPage<OrderListVo>> getPageOrderList(OrderQueryParam param);
}
