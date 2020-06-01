package com.learn.more_datasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.more_datasource.entity.UserEntity;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 9:50
 * @ClassName IUserService
 */
public interface IUserService extends IService<UserEntity> {

    /**
     * 添加
     * @param entity 实体类
     */
    void saveUserEntity(UserEntity entity);

}
