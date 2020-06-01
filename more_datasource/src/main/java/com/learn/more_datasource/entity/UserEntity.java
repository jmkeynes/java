package com.learn.more_datasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 9:49
 * @ClassName UserEntity
 */
@TableName("t_user")
public class UserEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
