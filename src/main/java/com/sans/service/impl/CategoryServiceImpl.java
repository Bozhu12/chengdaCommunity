package com.sans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.model.entity.Category;
import com.sans.service.CategoryService;
import com.sans.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author Sans
* @description 针对表【category(分类表)】的数据库操作Service实现
* @createDate 2023-04-14 20:09:19
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




