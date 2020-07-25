package com.learn.databases_cluster.service.impl;

import com.learn.databases_cluster.annotation.TargetDataSource;
import com.learn.databases_cluster.dao.CmsHelpDao;
import com.learn.databases_cluster.entity.CmsHelp;
import com.learn.databases_cluster.service.CmsHelpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 帮助表(CmsHelp)表服务实现类
 *
 * @author makejava
 * @since 2020-07-19 20:21:10
 */
@Service("cmsHelpService")
public class CmsHelpServiceImpl implements CmsHelpService {

    @Resource
    private CmsHelpDao cmsHelpDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @TargetDataSource
    public CmsHelp queryById(Long id) {
        return this.cmsHelpDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    @TargetDataSource
    public List<CmsHelp> queryAllByLimit(int offset, int limit) {
        return this.cmsHelpDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param cmsHelp 实例对象
     * @return 实例对象
     */
    @Override
    @TargetDataSource
    public CmsHelp insert(CmsHelp cmsHelp) {
        this.cmsHelpDao.insert(cmsHelp);
        return cmsHelp;
    }

    /**
     * 修改数据
     *
     * @param cmsHelp 实例对象
     * @return 实例对象
     */
    @Override
    @TargetDataSource
    public CmsHelp update(CmsHelp cmsHelp) {
        this.cmsHelpDao.update(cmsHelp);
        return this.queryById(cmsHelp.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @TargetDataSource
    public boolean deleteById(Long id) {
        return this.cmsHelpDao.deleteById(id) > 0;
    }
}
