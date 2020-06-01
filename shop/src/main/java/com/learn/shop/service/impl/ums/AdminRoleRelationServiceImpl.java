package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.AdminRoleRelationDao;
import com.learn.shop.entity.ums.AdminRoleRelationEntity;
import com.learn.shop.service.ums.IAdminRoleRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class AdminRoleRelationServiceImpl extends ServiceImpl<AdminRoleRelationDao, AdminRoleRelationEntity> implements IAdminRoleRelationService {

}
