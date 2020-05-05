package com.learn.elasticsearch.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.elasticsearch.entity.PmsProduct;
import com.learn.elasticsearch.nosql.document.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/4 16:04
 * @version： 1.0
 */
@Mapper
public interface PmsProductDao extends BaseMapper<PmsProduct> {

    @Select("<script>SELECT\n" +
            "\tp.id id,\n" +
            "\tp.product_sn productSn,\n" +
            "\tp.brand_id brandId,\n" +
            "\tp.brand_name brandName,\n" +
            "\tp.product_category_id productCategoryId,\n" +
            "\tp.product_category_name productCategoryName,\n" +
            "\tp.pic pic,\n" +
            "\tp.`name` `name`,\n" +
            "\tp.sub_title subTitle,\n" +
            "\tp.price price,\n" +
            "\tp.sale sale,\n" +
            "\tp.new_status newStatus,\n" +
            "\tp.recommand_status recommandStatus,\n" +
            "\tp.stock stock,\n" +
            "\tp.promotion_type promotionType,\n" +
            "\tp.keywords keywords,\n" +
            "\tp.sort sort\n" +
            "from\n" +
            "\tpms_product p\n" +
            "where\n" +
            "\tp.delete_status = 1\n" +
            "and p.publish_status = 1</script>")
    List<EsProduct> getAllEsProductList();


    @Select("<script>SELECT\n" +
            "\tp.id id,\n" +
            "\tp.product_sn productSn,\n" +
            "\tp.brand_id brandId,\n" +
            "\tp.brand_name brandName,\n" +
            "\tp.product_category_id productCategoryId,\n" +
            "\tp.product_category_name productCategoryName,\n" +
            "\tp.pic pic,\n" +
            "\tp.`name` `name`,\n" +
            "\tp.sub_title subTitle,\n" +
            "\tp.price price,\n" +
            "\tp.sale sale,\n" +
            "\tp.new_status newStatus,\n" +
            "\tp.recommand_status recommandStatus,\n" +
            "\tp.stock stock,\n" +
            "\tp.promotion_type promotionType,\n" +
            "\tp.keywords keywords,\n" +
            "\tp.sort sort\n" +
            "from\n" +
            "\tpms_product p\n" +
            "where\n" +
            "\tp.delete_status = 1\n" +
            "and p.publish_status = 1" +
            "&lt;if test=\"ids != null and ids.size >0\">&gt;"
                +"and" +"p.id in"+
                "&lt;foreach collection=\"ids\" item=\"id\" separator=\",\" open = \"(\"close=\")\"&gt;"+
                    "#{id}" +
                "&lt;/foreach &gt;"
            +"&lt;/foreach>&gt;"+
            "</script>")
    List<EsProduct> getEsProductListByIds(@Param("ids") List<Long> id);

    @Select("SELECT\n" +
            "\tp.id id,\n" +
            "\tp.product_sn productSn,\n" +
            "\tp.brand_id brandId,\n" +
            "\tp.brand_name brandName,\n" +
            "\tp.product_category_id productCategoryId,\n" +
            "\tp.product_category_name productCategoryName,\n" +
            "\tp.pic pic,\n" +
            "\tp.`name` `name`,\n" +
            "\tp.sub_title subTitle,\n" +
            "\tp.price price,\n" +
            "\tp.sale sale,\n" +
            "\tp.new_status newStatus,\n" +
            "\tp.recommand_status recommandStatus,\n" +
            "\tp.stock stock,\n" +
            "\tp.promotion_type promotionType,\n" +
            "\tp.keywords keywords,\n" +
            "\tp.sort sort\n" +
            "from\n" +
            "\tpms_product p\n" +
            "where\n" +
            "\tp.delete_status = 1\n" +
            "and p.publish_status = 1\n" +
            "AND p.id = #{id}")
    EsProduct getEsProductById(@Param("id") Long id);

}
