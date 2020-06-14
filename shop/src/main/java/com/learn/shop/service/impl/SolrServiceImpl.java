package com.learn.shop.service.impl;

import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.ISolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/14 16:13
 * @ClassName SolrServiceImpl
 */
@Service
public class SolrServiceImpl<T> implements ISolrService<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SolrServiceImpl.class);

    @Resource
    private SolrClient solrClient;


    @Override
    public ResultBean<Boolean> batchAddSolrHome(List<SolrInputDocument> list) {
        try {
            solrClient.add(list);
            solrClient.commit();
            return ResultBean.success(true);
        } catch (Exception e) {
            LOGGER.debug("\nsolr库批量新增失败信息：{}",e.getMessage());
            return ResultBean.failed(e.getMessage(), false);
        }
    }

    /**
     *
     * @param document 索引文档数据
     */
    @Override
    public ResultBean<Boolean> addSolrHome(SolrInputDocument document) {
        try {
            solrClient.add(document);
            solrClient.commit();
            return ResultBean.success(true);
        } catch (Exception e) {
            LOGGER.debug("\nsolr库新增失败信息{}",e.getMessage());
            return ResultBean.failed(e.getMessage(), false);
        }
    }

    /**
     * 根据查询 的条件进行查询，并将查的结果进行分页
     *
     * @param query 查询条件
     */
    @Override
    public ResultBean<T> getSolrHomeQueryPage(SolrQuery query) {
        try {
            QueryResponse response = solrClient.query(query);
            SolrDocumentList results = response.getResults();
            System.out.println(results.getNumFound());
        }catch (Exception e){
            LOGGER.debug("\n查询失败的结果：{}",e.getMessage());
        }
        return null;
    }

    /**
     * 根据id去删除索引库中的数据，成功返回true，失败返回一个false
     * @param id 索引id
     */
    @Override
    public ResultBean<Boolean> deleteBySolrHomeId(String id) {
        try {
            solrClient.deleteById(id);
            return ResultBean.success(true);
        } catch (Exception e) {
            LOGGER.debug("\nsolr删除失败信息{}",e.getMessage());
            return ResultBean.failed(e.getMessage(), false);
        }
    }

    /**
     * 根据ids去删除索引库中的数据，成功返回true，失败返回一个false
     *
     * @param ids id集合
     */
    @Override
    public ResultBean<Boolean> batchDeleteBySolrHomeByListId(List<String> ids) {
        try {
            solrClient.deleteById(ids);
            return ResultBean.success(true);
        } catch (Exception e) {
            LOGGER.debug("\nsolr批量删除失败信息{}",e.getMessage());
            return ResultBean.failed(e.getMessage(), false);
        }
    }
}
