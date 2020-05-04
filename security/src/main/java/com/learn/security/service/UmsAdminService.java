package com.learn.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.security.entity.UmsAdmin;
import com.learn.security.entity.UmsPermission;

import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/1 20:53
 * @version： 1.0
 * 后台管理员Service
 */
public interface UmsAdminService extends IService<UmsPermission> {

    /**
     * 根据用户获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
