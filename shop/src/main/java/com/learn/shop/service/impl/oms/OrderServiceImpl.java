package com.learn.shop.service.impl.oms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.oms.OrderDao;
import com.learn.shop.dto.oms.OrderQueryParam;
import com.learn.shop.entity.oms.OrderEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.oms.IOrderService;
import com.learn.shop.vo.oms.OrderListVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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

    @Override
    public ResultBean<IPage<OrderListVo>> getPageOrderList(OrderQueryParam param) {

        Page<OrderListVo> page = new Page<>(param.getPage(), param.getLimit());
        Map<String, Object> map = new HashMap<>();
        //匹配中文正则表达式
        String pattern = "[\\u4e00-\\u9fa5]";
        if (param.getMemberOrPhone() != null) {
            boolean matches = Pattern.matches(pattern, param.getMemberOrPhone());

            if (matches) {
                String name = param.getMemberOrPhone();
                map.put("name", name);
            } else {
                String phone = param.getMemberOrPhone();
                map.put("phone", phone);
            }
        }
        return ResultBean.success(this.baseMapper.getPageOrderList(page, param,map));
    }
}
