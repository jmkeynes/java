package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.PermissionDao;
import com.learn.shop.entity.ums.PermissionEntity;
import com.learn.shop.service.ums.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, PermissionEntity> implements IPermissionService {

}
