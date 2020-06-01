package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.MemberLoginLogDao;
import com.learn.shop.entity.ums.MemberLoginLogEntity;
import com.learn.shop.service.ums.IMemberLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员登录记录 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogDao, MemberLoginLogEntity> implements IMemberLoginLogService {

}
