package com.learn.elasticsearch.dao.repository;

import com.learn.elasticsearch.nosql.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author：江文谱
 * @date： 2020/5/4 15:50
 * @version： 1.0
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    /**
     * 搜索查询
     * @param name 商品名称
     * @param subTitle 商品标题
     * @param keyword  商品关键字
     * @param pageable 分页信息
     */
    Page<EsProduct> findByNameOrSubTitleOrKeyword(String name, String subTitle, String keyword, Pageable pageable);
}
