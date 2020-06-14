package com.learn.shop.pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/14 18:22
 * @ClassName SolrProductEntity
 */
@Setter
@Getter
@SolrDocument(collection = "solrhome")
public class SolrProductEntity implements Serializable, Cloneable {

    @Field("id")
    private String id;

    @Field("name")
    private String name;

    @Field("price")
    private String price;

}
