package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.MemberProductCategoryRelationDao;
import com.learn.shop.entity.ums.MemberProductCategoryRelationEntity;
import com.learn.shop.service.ums.IMemberProductCategoryRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类） 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class MemberProductCategoryRelationServiceImpl extends ServiceImpl<MemberProductCategoryRelationDao, MemberProductCategoryRelationEntity> implements IMemberProductCategoryRelationService {

}
