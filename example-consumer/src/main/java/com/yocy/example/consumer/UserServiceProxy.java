package com.yocy.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.yocy.example.common.model.User;
import com.yocy.example.common.service.UserService;
import com.yocy.yirpc.model.RpcRequest;
import com.yocy.yirpc.model.RpcResponse;
import com.yocy.yirpc.serializer.JdkSerializer;
import com.yocy.yirpc.serializer.Serializer;

/**
 * 静态代理
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class UserServiceProxy implements UserService {
    
    @Override
    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();
        
        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }

            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
