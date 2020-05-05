package com.learn.elasticsearch;

import com.learn.elasticsearch.service.IEsProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ElasticsearchApplicationTests {

    @Autowired
    private IEsProductService service;


    @Test
    public void contextLoads() {
        System.out.println(service.importAll());
//        System.out.println(service.getById(1));
//        System.out.println(productDao.getEsProductById(1L));
    }

}
