package com.learn.shop.service.impl.pms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.BrandDao;
import com.learn.shop.dto.pms.BrandQueryParam;
import com.learn.shop.entity.pms.BrandEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IBrandService;
import com.learn.shop.vo.pms.BrandVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements IBrandService {

    /**
     * 根据参数查询品牌分页列表
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    @Override
    public ResultBean<IPage<BrandVo>> getPageBrandList(BrandQueryParam param) {
        Page<BrandVo> page = new Page<>(param.getPage(), param.getLimit());
        IPage<BrandVo> iPage = this.baseMapper.getPageBrandList(page, param);
        return ResultBean.success(iPage);
    }
}
