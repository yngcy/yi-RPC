package com.yocy.yirpc.loadbalancer;

/**
 * 负载均衡器键名常量
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface LoadBalancerKeys {
    
    String ROUND_ROBIN = "roundRobin";
    
    String RANDOM = "random";
    
    String CONSTRAINT_HASH = "constraintHash";
}
