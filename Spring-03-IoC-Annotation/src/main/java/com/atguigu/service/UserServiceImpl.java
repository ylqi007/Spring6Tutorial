package com.atguigu.service;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:15
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("执行 UserServiceImpl.add() --> UserDao.add()...");
        userDao.add();
    }
}
