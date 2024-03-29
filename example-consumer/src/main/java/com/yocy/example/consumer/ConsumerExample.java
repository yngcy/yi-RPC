package com.yocy.example.consumer;

import com.yocy.yirpc.config.RpcConfig;
import com.yocy.yirpc.utils.ConfigUtils;

/**
 * 简易消费者示例
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc =  ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
