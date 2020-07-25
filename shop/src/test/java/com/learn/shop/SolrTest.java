package com.learn.shop;

import com.learn.shop.pojo.SolrProductEntity;
import com.learn.shop.service.ISolrService;
import org.apache.solr.client.solrj.SolrQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/14 17:06
 * @ClassName SolrTest
 */
@SpringBootTest
public class SolrTest {

    @Autowired
    private ISolrService solrService;

    @Test
    void test() {
        SolrProductEntity entity = new SolrProductEntity();
        entity.setId("3");
        entity.setName("华为好公司");
        entity.setPrice("20.00");
        ArrayList<SolrProductEntity> arrayList = new ArrayList<>();
        arrayList.add(entity);
        System.out.println(solrService.batchAddSolrHome(arrayList));
//        System.out.println(solrService.addSolrHome(com.learn.databases_cluster.entity));

    }

    @Test
    void testQuery() {
        SolrQuery query = new SolrQuery();
//        query.setRows(2);
//        query.setStart(1);
//        query.set("q","name:手");
        query.setQuery("product_sn:No86577");
        query.setQuery("product_sn:No86577");
        query.setQuery("product_sn:No86577");
        query.setQuery("product_sn:No86577");
        query.setQuery("product_sn:No86577");
//        ResultBean bean = solrService.getSolrHomeQueryPage(query);
//        System.out.println(bean);

    }

    @Test
    void testDel() {
        System.out.println(solrService.deleteBySolrHomeId("1"));
        List<String> ids = new ArrayList<>();
        ids.add("2");
        ids.add("3");
        System.out.println(solrService.batchDeleteBySolrHomeByListId(ids));
    }

}
