package com.atguigu.resource.service;

import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:47
 */
@Service(value = "resourceUserRedisServiceImpl")
public class UserRedisServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("执行 UserRedisServiceImpl.add()... ");
    }
}
