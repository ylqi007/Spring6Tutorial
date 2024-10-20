package com.atguigu.resource.dao;

import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:16
 */
@Repository(value = "resourceUserDaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("执行 UserDaoImpl.add() ...");
    }
}
