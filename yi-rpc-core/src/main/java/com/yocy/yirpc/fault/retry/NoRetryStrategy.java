package com.yocy.yirpc.fault.retry;

import com.yocy.yirpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * 不重试
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class NoRetryStrategy implements RetryStrategy {
    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        return callable.call();
    }
}
