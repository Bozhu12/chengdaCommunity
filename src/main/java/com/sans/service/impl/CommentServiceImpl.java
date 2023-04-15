package com.sans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.model.entity.Comment;
import com.sans.service.CommentService;
import com.sans.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Sans
* @description 针对表【comment(评论表)】的数据库操作Service实现
* @createDate 2023-04-14 20:09:19
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




