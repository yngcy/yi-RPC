package com.yocy.yirpc.loadbalancer;

import com.yocy.yirpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;

/**
 * 负载均衡器（消费端使用）
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface LoadBalancer {
    /**
     * 选择服务调用
     * @param requestParams
     * @param serviceMetaInfoList
     * @return
     */
    ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList);
}
