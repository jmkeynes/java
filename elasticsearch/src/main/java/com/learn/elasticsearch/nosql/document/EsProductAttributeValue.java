package com.learn.elasticsearch.nosql.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author：江文谱
 * @date： 2020/5/4 15:45
 * @version： 1.0
 */
@Setter
@Getter
public class EsProductAttributeValue {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long productAttributeId;

    //属性值
    @Field(type = FieldType.Keyword)
    private String value;

    //属性参数：0->规格；1->参数
    private Integer type;

    //属性名称
    @Field(type = FieldType.Keyword)
    private String name;
}
