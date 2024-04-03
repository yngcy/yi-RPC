package com.yocy.examplespringbootconsumer;

import com.yocy.example.common.model.User;
import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.springboot.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

/**
 * 示例服务实现类
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Service
public class ExampleServiceImpl {

    /**
     * 使用 Rpc 框架注入
     */
    @RpcReference
    private UserService userService;

    /**
     * 测试方法
     */
    public void test() {
        User user = new User();
        user.setName("yocy");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}
