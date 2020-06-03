package com.learn.shop.dao.oms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.shop.dto.oms.OrderQueryParam;
import com.learn.shop.entity.oms.OrderEntity;
import com.learn.shop.vo.oms.OrderListVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface OrderDao extends BaseMapper<OrderEntity> {

    IPage<OrderListVo> getPageOrderList(@Param("page") Page<OrderListVo> page, @Param("param") OrderQueryParam param, @Param("map") Map<String, Object> map);
}
