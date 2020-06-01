package com.learn.more_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.more_datasource.constant.db.config.Datasource;
import com.learn.more_datasource.dao.UserDao;
import com.learn.more_datasource.entity.UserEntity;
import com.learn.more_datasource.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 9:50
 * @ClassName UserServiceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements IUserService {

    /**
     * 添加到  mysql 137的数据库
     * @param entity 实体类
     */
    @Override
    @DS(Datasource.MYSQL_137)
    public boolean save(UserEntity entity) {
        return super.save(entity);
    }

    /**
     * 添加到 mysql 136 默认的数据库
     * @param entity 实体类
     */
    @Override
    public void saveUserEntity(UserEntity entity) {
        super.save(entity);
    }
}
