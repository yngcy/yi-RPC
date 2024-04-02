package com.yocy.yirpc.fault.retry;

import com.yocy.yirpc.model.RpcResponse;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class RetryStrategyTest {

    RetryStrategy retryStrategy = new FixedIntervalRetryStrategy();
    
    @Test
    public void doRetry() {
        try {
            RpcResponse rpcResponse = retryStrategy.doRetry(() -> {
                System.out.println("重试测试");
                throw new RuntimeException("模拟重试失败");
            });
            System.out.println(rpcResponse);
        } catch (Exception e) {
            System.out.println("重试多次失败");
            e.printStackTrace();
        }
    }
}