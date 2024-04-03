package com.yocy.example.provider;

import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.bootstrap.ProviderBootstrap;
import com.yocy.yirpc.model.ServiceRegisterInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务提供者示例类
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ProviderExample {

    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);
        
        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);

    }
}
