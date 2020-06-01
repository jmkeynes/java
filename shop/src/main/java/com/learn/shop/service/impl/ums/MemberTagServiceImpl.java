package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.MemberTagDao;
import com.learn.shop.entity.ums.MemberTagEntity;
import com.learn.shop.service.ums.IMemberTagService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户标签表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class MemberTagServiceImpl extends ServiceImpl<MemberTagDao, MemberTagEntity> implements IMemberTagService {

}
