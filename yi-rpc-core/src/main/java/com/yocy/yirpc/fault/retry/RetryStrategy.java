package com.yocy.yirpc.fault.retry;

import com.yocy.yirpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * 重试策略
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface RetryStrategy {

    /**
     * 重试
     * @param callable
     * @return
     * @throws Exception
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}
