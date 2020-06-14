package com.learn.shop.service;

import com.learn.shop.pojo.result.ResultBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.SolrInputDocument;

import java.util.List;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/14 16:14
 * @ClassName ISolrService
 */
public interface ISolrService<T> {

    /**
     * 更新或新增solr索引库
     * @author JWP
     * @date 2020-6-14
     * @param document 索引文档数据
     */
    ResultBean<Boolean> addSolrHome(SolrInputDocument document);

    /**
     * 查询索引库中的数据根据关键字,并分页
     * @author JWP
     * @date 2020-6-14
     * @param query 查询条件
     */
    ResultBean<T> getSolrHomeQueryPage(SolrQuery query);

    /**
     * 删除索引库中的数据根据id
     * @author JWP
     * @date 2020-6-14
     * @param id 索引id
     */
    ResultBean<Boolean> deleteBySolrHomeId(String id);


    /**
     * 批量删除索引库中数据根据id集合
     * @author JWP
     * @date 2020-6-14
     * @param ids id集合
     */
    ResultBean<Boolean> batchDeleteBySolrHomeByListId(List<String> ids);

    /**
     * 批量新增索引库中数据
     * @author JWP
     * @date 2020-6-14
     * @param list 索引数据集合
     */
    ResultBean<Boolean> batchAddSolrHome(List<SolrInputDocument> list);

}
