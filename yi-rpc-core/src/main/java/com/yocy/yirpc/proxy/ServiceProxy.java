package com.yocy.yirpc.proxy;

import cn.hutool.core.collection.CollUtil;
import com.yocy.yirpc.RpcApplication;
import com.yocy.yirpc.config.RpcConfig;
import com.yocy.yirpc.constant.RpcConstant;
import com.yocy.yirpc.loadbalancer.LoadBalancer;
import com.yocy.yirpc.loadbalancer.LoadBalancerFactory;
import com.yocy.yirpc.model.RpcRequest;
import com.yocy.yirpc.model.RpcResponse;
import com.yocy.yirpc.model.ServiceMetaInfo;
import com.yocy.yirpc.registry.Registry;
import com.yocy.yirpc.registry.RegistryFactory;
import com.yocy.yirpc.serializer.Serializer;
import com.yocy.yirpc.serializer.SerializerFactory;
import com.yocy.yirpc.server.tcp.VertxTcpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务代理（JDK 动态代理）
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ServiceProxy implements InvocationHandler {

    /**
     * 调用代理
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 指定序列化器
        final Serializer serializer = SerializerFactory.getInstance(RpcApplication.getRpcConfig().getSerializer());
        String serviceName = method.getDeclaringClass().getName();
        
        // 构造请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(serviceName)
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .build();
        
        try {
            // 从注册中心获取服务提供者请求地址
            RpcConfig rpcConfig = RpcApplication.getRpcConfig();
            Registry registry = RegistryFactory.getInstance(rpcConfig.getRegistryConfig().getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceVersion(RpcConstant.DEFAULT_SERVICE_VERSION);
            List<ServiceMetaInfo> serviceMetaInfoList =  registry.serviceDiscovery(serviceMetaInfo.getServiceKey());
            if (CollUtil.isEmpty(serviceMetaInfoList)) {
                throw new RuntimeException("暂无服务地址");
            }
            // 负载均衡
            LoadBalancer loadBalancer = LoadBalancerFactory.getInstance(rpcConfig.getLoadBalancer());
            // 将方法名（请求路径）作为负载均衡参数
            Map<String, Object> requestParams = new HashMap<>();
            requestParams.put("methodName", rpcRequest.getMethodName());
            ServiceMetaInfo selectedServiceMetaInfo = loadBalancer.select(requestParams, serviceMetaInfoList);
            
            // 发送 TCP 请求
            RpcResponse rpcResponse = VertxTcpClient.doRequest(rpcRequest, selectedServiceMetaInfo);
            return rpcResponse;
        } catch (Exception e) {
            throw new RuntimeException("调用失败");
        }
        
    }
}
