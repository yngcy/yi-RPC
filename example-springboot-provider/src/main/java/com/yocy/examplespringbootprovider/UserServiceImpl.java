package com.yocy.examplespringbootprovider;

import com.yocy.example.common.model.User;
import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.springboot.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Service
@RpcService
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
