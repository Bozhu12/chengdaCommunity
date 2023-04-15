package com.sans.service;

import com.sans.model.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Sans
* @description 针对表【users(用户表)】的数据库操作Service
* @createDate 2023-04-14 20:09:19
*/
public interface UsersService extends IService<Users> {

    String login(String username, String password);

    boolean register(Users users);
}
