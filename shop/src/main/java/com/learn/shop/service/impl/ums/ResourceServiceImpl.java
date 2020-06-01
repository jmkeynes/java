package com.learn.shop.service.impl.ums;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.ums.ResourceDao;
import com.learn.shop.entity.ums.ResourceEntity;
import com.learn.shop.service.ums.IResourceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceEntity> implements IResourceService {

}
