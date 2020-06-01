package com.learn.shop.service.impl.product;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.product.CommentReplayDao;
import com.learn.shop.entity.product.CommentReplayEntity;
import com.learn.shop.service.product.ICommentReplayService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品评价回复表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayDao, CommentReplayEntity> implements ICommentReplayService {

}
