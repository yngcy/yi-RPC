package com.yocy.yirpc.bootstrap;

import com.yocy.yirpc.RpcApplication;

/**
 * 服务消费者启动类（初始化）
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ConsumerBootstrap {

    /**
     * 初始化
     *
     */
    public static void init() {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
    }
}
