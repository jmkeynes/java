package com.learn.security;

import com.learn.security.service.UmsAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private UmsAdminService adminService;

    @Test
    void contextLoads() {
        System.out.println(adminService.login("test", "123456"));
    }

    @Test
    void test(){
        System.out.println(adminService.getAdminByUsername("test"));
    }

}
