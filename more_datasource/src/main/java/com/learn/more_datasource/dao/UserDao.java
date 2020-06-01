package com.learn.more_datasource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.more_datasource.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 9:51
 * @ClassName UserDao  实体dao
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
