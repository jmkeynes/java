package com.learn.elasticsearch.service;

import com.learn.elasticsearch.nosql.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/4 15:53
 * @version： 1.0
 */
public interface IEsProductService {

    /**
     * 从数据库中导入所有的商品到ES
     *
     * @return
     */
    Boolean importAll();

    /**
     * 根据ID删除商品
     *
     * @param id id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 根据IDS批量删除商品
     *
     * @param ids 商品ID集合
     * @return
     */
    Boolean batchDelete(List<Long> ids);

    /**
     * 根据ID创建商品
     *
     * @param id id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 根据关键字搜索名称或者副标题
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
