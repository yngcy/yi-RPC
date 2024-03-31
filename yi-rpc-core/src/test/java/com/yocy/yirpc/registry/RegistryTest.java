package com.yocy.yirpc.registry;

import com.yocy.yirpc.config.RegistryConfig;
import com.yocy.yirpc.model.ServiceMetaInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 注册中心测试
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class RegistryTest {
    final Registry registry = new EtcdRegistry();
    
    
    @Before
    public void init() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("http://localhost:2379");
        registry.init(registryConfig);
    }

    @Test
    public void registry() throws Exception {
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName("myService");
        serviceMetaInfo.setServiceVersion("1.0");
        serviceMetaInfo.setServiceHost("localhost");
        serviceMetaInfo.setServicePort(1234);
        registry.register(serviceMetaInfo);

        serviceMetaInfo.setServiceName("myService");
        serviceMetaInfo.setServiceVersion("1.0");
        serviceMetaInfo.setServiceHost("localhost");
        serviceMetaInfo.setServicePort(1235);
        registry.register(serviceMetaInfo);

        serviceMetaInfo.setServiceName("myService");
        serviceMetaInfo.setServiceVersion("2.0");
        serviceMetaInfo.setServiceHost("localhost");
        serviceMetaInfo.setServicePort(1234);
        registry.register(serviceMetaInfo);
        
        serviceMetaInfo.setServiceName("myService");
        serviceMetaInfo.setServiceVersion("3.0");
        serviceMetaInfo.setServiceHost("localhost");
        serviceMetaInfo.setServicePort(1234);
        registry.register(serviceMetaInfo);
    }

//    @Test
//    public void unRegistry() throws Exception {
//        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
//        serviceMetaInfo.setServiceName("myService");
//        serviceMetaInfo.setServiceVersion("1.0");
//        serviceMetaInfo.setServiceHost("localhost");
//        serviceMetaInfo.setServicePort(1234);
//        registry.unRegistry(serviceMetaInfo);
//    }

    @Test
    public void serviceDiscovery() {
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName("myService");
        serviceMetaInfo.setServiceVersion("1.0");
        String serviceKey = serviceMetaInfo.getServiceKey();
        List<ServiceMetaInfo> serviceMetaInfoList = registry.serviceDiscovery(serviceKey);
        Assert.assertNotNull(serviceMetaInfoList);
    }

}
