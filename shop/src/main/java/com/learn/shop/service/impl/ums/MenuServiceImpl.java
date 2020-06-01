package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.MenuDao;
import com.learn.shop.entity.ums.MenuEntity;
import com.learn.shop.service.ums.IMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements IMenuService {

}
