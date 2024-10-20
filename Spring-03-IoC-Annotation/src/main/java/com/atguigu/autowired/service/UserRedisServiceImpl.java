package com.atguigu.autowired.service;

import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:47
 */
@Service
public class UserRedisServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("执行 UserRedisServiceImpl.add()... ");
    }
}
