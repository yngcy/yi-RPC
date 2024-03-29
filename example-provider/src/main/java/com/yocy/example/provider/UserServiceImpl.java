package com.yocy.example.provider;

import com.yocy.example.common.model.User;
import com.yocy.example.common.service.UserService;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {

        System.out.println("用户名：" + user.getName());
        return user;
    }
}
