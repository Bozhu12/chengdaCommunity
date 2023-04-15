package com.sans.service;

import com.sans.model.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Resource
    private UsersService userService;

    @Test
    public void testSomeMethod() {
        List<Users> list = userService.list();
        for (Users users : list) {
            System.out.println("users => " + users);
        }
    }

}
