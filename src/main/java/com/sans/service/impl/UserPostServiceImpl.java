package com.sans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.model.entity.UserPost;
import com.sans.service.UserPostService;
import com.sans.mapper.UserPostMapper;
import org.springframework.stereotype.Service;

/**
* @author Sans
* @description 针对表【user_post(用户帖子表)】的数据库操作Service实现
* @createDate 2023-04-14 20:09:19
*/
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost>
    implements UserPostService{

}




