package com.yocy.yirpc.registry;

import com.yocy.yirpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * 注册中心服务本地缓存
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class RegistryServiceCache {

    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     * @param newServiceCache
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存
     * @return
     */
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        this.serviceCache = null;
    }
    
}
