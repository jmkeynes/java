package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.MemberDao;
import com.learn.shop.entity.ums.MemberEntity;
import com.learn.shop.service.ums.IMemberService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements IMemberService {

}
