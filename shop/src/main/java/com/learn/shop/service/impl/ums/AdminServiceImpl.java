package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.AdminDao;
import com.learn.shop.entity.ums.AdminEntity;
import com.learn.shop.service.ums.IAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements IAdminService {

}
