package com.sans.controller;

import cn.hutool.core.bean.BeanUtil;
import com.sans.common.BaseResponse;
import com.sans.model.entity.Users;
import com.sans.model.request.UserLoginRequest;
import com.sans.model.request.UserRegisterRequest;
import com.sans.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sans
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UsersService usersService;


    @GetMapping("/all")
    public BaseResponse<List<Users>> getAllUsers() {
        List<Users> users = usersService.list();
        return BaseResponse.ok(users);
    }

    @GetMapping("/{id}")
    public BaseResponse<Users> getUserById(@PathVariable Long id) {
        Users user = usersService.getById(id);
        return BaseResponse.ok(user);
    }

    @PostMapping("/edit/{id}")
    public BaseResponse<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        user.setId(id);
        usersService.save(user);
        return BaseResponse.ok(user);
    }

    @GetMapping("/del/{id}")
    public BaseResponse<Boolean> deleteUser(@PathVariable Long id) {
        boolean remove = usersService.removeById(id);
        return BaseResponse.ok(remove);
    }

    /*
      登录功能
      退出功能
      当前用户
     */

    /**
     * 登录功能
     * @param user
     * @return token
     */
    @PostMapping("/login")
    public BaseResponse<String> login(@RequestBody UserLoginRequest user) {
        String token = usersService.login(user.getUsername(), user.getPassword());
        return BaseResponse.ok(token);
    }

    @PostMapping("/register")
    public BaseResponse<Boolean> createUser(@RequestBody UserRegisterRequest register) {
        Users users = BeanUtil.copyProperties(register, Users.class);
        boolean success = usersService.register(users);
        return BaseResponse.ok(success);
    }


}