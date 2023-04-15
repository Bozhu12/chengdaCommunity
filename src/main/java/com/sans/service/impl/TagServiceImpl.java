package com.sans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.model.entity.Tag;
import com.sans.service.TagService;
import com.sans.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Sans
* @description 针对表【tag(标签表)】的数据库操作Service实现
* @createDate 2023-04-14 20:09:19
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




