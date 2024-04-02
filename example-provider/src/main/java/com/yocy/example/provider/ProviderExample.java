package com.yocy.example.provider;

import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.RpcApplication;
import com.yocy.yirpc.config.RegistryConfig;
import com.yocy.yirpc.config.RpcConfig;
import com.yocy.yirpc.model.ServiceMetaInfo;
import com.yocy.yirpc.registry.LocalRegistry;
import com.yocy.yirpc.registry.Registry;
import com.yocy.yirpc.registry.RegistryFactory;
import com.yocy.yirpc.server.HttpServer;
import com.yocy.yirpc.server.VertxHttpServer;
import com.yocy.yirpc.server.tcp.VertxTcpServer;
import io.vertx.core.Vertx;

/**
 * 服务提供者示例类
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();
        
        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);
        
        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
