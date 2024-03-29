package com.yocy.example.consumer;

import com.yocy.example.common.model.User;
import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.proxy.ServiceProxyFactory;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("John");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user is null!");
        }
    }
}
