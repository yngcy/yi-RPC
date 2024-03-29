package com.yocy.example.consumer;

import com.yocy.example.common.model.User;
import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.config.RpcConfig;
import com.yocy.yirpc.proxy.ServiceProxyFactory;
import com.yocy.yirpc.utils.ConfigUtils;

/**
 * 简易消费者示例
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yocy");
        //调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user is null!");
        }
        long number = userService.getNumber();
        System.out.println(number);
        
    }
}
