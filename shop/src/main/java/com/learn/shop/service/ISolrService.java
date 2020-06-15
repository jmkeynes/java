package com.learn.shop.service;

import com.learn.shop.pojo.result.ResultBean;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;

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
     *
     * @param t 索引文档数据
     * @return 执行结果
     * @author JWP
     * @date 2020-6-14
     */
    ResultBean<Boolean> addSolrHome(T t);

    /**
     * 查询索引库中的数据根据关键字,并分页
     *
     * @param query 查询条件
     * @return 执行结果
     * @author JWP
     * @date 2020-6-14
     */
    SolrDocumentList getSolrHomeQueryPage(ModifiableSolrParams query);

    /**
     * 删除索引库中的数据根据id
     *
     * @param id 索引id
     * @return 执行结果
     * @author JWP
     * @date 2020-6-14
     */
    ResultBean<Boolean> deleteBySolrHomeId(String id);


    /**
     * 批量删除索引库中数据根据id集合
     *
     * @param ids id集合
     * @return 执行结果
     * @author JWP
     * @date 2020-6-14
     */
    ResultBean<Boolean> batchDeleteBySolrHomeByListId(List<String> ids);

    /**
     * 批量新增索引库中数据
     *
     * @param list 索引数据集合
     * @return 执行结果
     * @author JWP
     * @date 2020-6-14
     */
    ResultBean<Boolean> batchAddSolrHome(List<T> list);

    /**
     * 根据关键字查询数据
     *
     * @param keyword 关键字
     * @return 查询结果
     */
    ResultBean<SolrDocumentList> searchProduct(String keyword, Integer page, Integer limit);
}
