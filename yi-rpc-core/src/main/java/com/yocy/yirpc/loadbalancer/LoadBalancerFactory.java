package com.yocy.yirpc.loadbalancer;

import com.yocy.yirpc.spi.SpiLoader;

/**
 * 负载均衡工厂（工厂模式，用于获取负载均衡器对象）
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class LoadBalancerFactory {
    static {
        SpiLoader.load(LoadBalancer.class);
    }

    /**
     * 默认负载均衡器
     */
    public static final LoadBalancer DEFAULT_LOAD_BALANCER = new RoundRobinLoadBalancer();

    /**
     * 获取负载均衡器
     * @param key
     * @return
     */
    public static LoadBalancer getInstance(String key) {
        return SpiLoader.getInstance(LoadBalancer.class, key);
    }
}
