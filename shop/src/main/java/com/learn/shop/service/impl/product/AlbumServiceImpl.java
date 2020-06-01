package com.learn.shop.service.impl.product;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.AlbumDao;
import com.learn.shop.entity.pms.AlbumEntity;
import com.learn.shop.service.product.IAlbumService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相册表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumDao, AlbumEntity> implements IAlbumService {

}