package com.learn.more_datasource;

import com.learn.more_datasource.entity.UserEntity;
import com.learn.more_datasource.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoreDatasourceApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {

        UserEntity entity  = new UserEntity();
        entity.setUsername("666666");
        userService.save(entity);
        userService.saveUserEntity(entity);
    }

}
