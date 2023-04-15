package com.sans.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sans.common.ErrorCode;
import com.sans.common.UserHolder;
import com.sans.exception.BusinessException;
import com.sans.model.dto.UserDTO;
import com.sans.model.entity.Users;
import com.sans.service.UsersService;
import com.sans.mapper.UsersMapper;
import com.sans.utils.IdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.sans.common.RedisConstants.LOGIN_USER_KEY;
import static com.sans.common.RedisConstants.LOGIN_USER_TTL;

/**
 * @author Sans
 * @description 针对表【users(用户表)】的数据库操作Service实现
 * @createDate 2023-04-14 20:09:19
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 盐值，混淆密码
     */
    private static final String SALT = "sans";

    @Override
    public String login(String username, String password) {
        // 校验
        if (StringUtils.isAnyBlank(username, password)) throw new BusinessException(ErrorCode.LOGIN_ERROR);
        // md5加密
        password = DigestUtils.md5DigestAsHex((SALT + password).getBytes(StandardCharsets.UTF_8));
        // 判断存在
        QueryWrapper<Users> qw = new QueryWrapper<>();
        qw.eq("username", username);
        qw.eq("password", password);
        Users user = this.getOne(qw);
        if (BeanUtil.isEmpty(user)) throw new BusinessException(ErrorCode.LOGIN_ERROR);
        // 存在脱敏
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        // 记录token
        String token = UUID.randomUUID().toString();
        // TODO 拼接设配信息
        // 记录用户 , 以hash结构记录用户信息
        UserHolder.saveUser(userDTO);
        String redisTokenKey = LOGIN_USER_KEY + token;
        // Convert UserDTO object to Map<String, Object>
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO);
        redisTemplate.opsForHash().putAll(redisTokenKey, userMap);
        redisTemplate.expire(redisTokenKey, LOGIN_USER_TTL, TimeUnit.DAYS);
        return token;
    }

    @Override
    public boolean register(Users users) {
        // 验证数据
        // 用户名,密码,邮箱,名称 不能为空
        if (StringUtils.isAnyBlank(users.getUsername(), users.getPassword(), users.getNickname(), users.getEmail()))
            throw new BusinessException(ErrorCode.DATA_CANNOT_BE_EMPTY);
        if (!users.getUsername().matches("^[a-zA-Z0-9_]+$"))
            throw new BusinessException(ErrorCode.USERNAME_CANNOT_CONTAIN_SYMBOLS);
        // 填充数据
        users.setId(IdGenerator.nextId());
        users.setPassword(DigestUtils.md5DigestAsHex((SALT + users.getPassword()).getBytes(StandardCharsets.UTF_8)));
        return this.save(users);
    }
}




