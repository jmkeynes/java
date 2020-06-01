package com.learn.shop.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.oms.CartItemDao;
import com.learn.shop.entity.oms.CartItemEntity;
import com.learn.shop.service.oms.ICartItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemDao, CartItemEntity> implements ICartItemService {

}
