package com.yocy.yirpc;

import com.yocy.yirpc.config.RpcConfig;
import com.yocy.yirpc.config.RegistryConfig;
import com.yocy.yirpc.constant.RpcConstant;
import com.yocy.yirpc.registry.Registry;
import com.yocy.yirpc.registry.RegistryFactory;
import com.yocy.yirpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * RPC 框架应用<br/>
 * 相当于存放 holder，存放了项目全局用到的变量。双检锁单例模式实现
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Slf4j
public class RpcApplication {
    
    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义参数
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config: {}", newRpcConfig.toString());
        // 注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);
    }
    
    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            // 配置加载失败，使用默认值
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     * 获取配置
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
