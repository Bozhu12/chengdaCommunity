package com.sans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.model.entity.Posttag;
import com.sans.service.PosttagService;
import com.sans.mapper.PosttagMapper;
import org.springframework.stereotype.Service;

/**
* @author Sans
* @description 针对表【posttag(帖子标签表)】的数据库操作Service实现
* @createDate 2023-04-14 20:09:19
*/
@Service
public class PosttagServiceImpl extends ServiceImpl<PosttagMapper, Posttag>
    implements PosttagService{

}




