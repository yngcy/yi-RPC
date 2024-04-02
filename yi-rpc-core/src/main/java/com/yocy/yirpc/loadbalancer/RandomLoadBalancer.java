package com.yocy.yirpc.loadbalancer;

import com.yocy.yirpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 随机负载均衡器
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class RandomLoadBalancer implements LoadBalancer {
    
    private final Random random = new Random();
    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList) {
        int size = serviceMetaInfoList.size();
        if (size == 0) {
            return null;
        }
        // 只有一个服务，不用随机
        if (1 == size) {
            return serviceMetaInfoList.get(0);
        }
        return serviceMetaInfoList.get(random.nextInt(size));
    }
}
