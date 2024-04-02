package com.yocy.yirpc.config;

import com.yocy.yirpc.fault.retry.RetryStrategy;
import com.yocy.yirpc.fault.retry.RetryStrategyKeys;
import com.yocy.yirpc.loadbalancer.LoadBalancerKeys;
import com.yocy.yirpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * RPC 框架配置
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "yi-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器地址
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口
     */
    private Integer serverPort = 8080;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.RANDOM;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.NO;
    
}
