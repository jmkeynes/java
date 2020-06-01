package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.AdminPermissionRelationDao;
import com.learn.shop.entity.ums.AdminPermissionRelationEntity;
import com.learn.shop.service.ums.IAdminPermissionRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationDao, AdminPermissionRelationEntity> implements IAdminPermissionRelationService {

}
