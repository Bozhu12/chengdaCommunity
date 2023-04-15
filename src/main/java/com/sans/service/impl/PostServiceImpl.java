package com.sans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.model.entity.Post;
import com.sans.service.PostService;
import com.sans.mapper.PostMapper;
import org.springframework.stereotype.Service;

/**
* @author Sans
* @description 针对表【post(帖子表)】的数据库操作Service实现
* @createDate 2023-04-14 20:09:19
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService{

}




