package com.yocy.yirpc.fault.tolerant;

import com.yocy.yirpc.model.RpcResponse;

import java.util.Map;

/**
 * 容错策略
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface TolerantStrategy {

    /**
     * 容错
     * @param context
     * @param e
     * @return
     */
    RpcResponse doTolerant(Map<String, Object> context, Exception e);
}
