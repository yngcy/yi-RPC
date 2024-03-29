package com.yocy.example.provider;

import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.registry.LocalRegistry;
import com.yocy.yirpc.server.HttpServer;
import com.yocy.yirpc.server.VertxHttpServer;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        
        System.out.println("Service registered.");

        System.out.println(LocalRegistry.get(UserService.class.getName()));
        
        // 提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
