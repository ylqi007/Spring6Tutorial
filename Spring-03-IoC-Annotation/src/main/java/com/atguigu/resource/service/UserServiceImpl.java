package com.atguigu.resource.service;

import com.atguigu.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:15
 */
@Service(value = "resourceUserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("执行 UserServiceImpl.add() --> UserDao.add()...");
        userDao.add();
    }
}
