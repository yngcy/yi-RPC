package com.yocy.yirpc.fault.tolerant;

import com.yocy.yirpc.model.RpcResponse;

import java.util.Map;

/**
 * 快速失败 - 容错策略（立刻通知外层调用方）
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class FailFastTolerantStrategy implements TolerantStrategy {
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        throw new RuntimeException("服务错误", e);
    }
}
