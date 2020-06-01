package com.learn.shop.service.impl.pms;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.CommentDao;
import com.learn.shop.entity.pms.CommentEntity;
import com.learn.shop.service.pms.ICommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements ICommentService {

}
