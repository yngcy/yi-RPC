package com.yocy.yirpc.fault.tolerant;

import com.yocy.yirpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 降级到其他服务 - 容错策略
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Slf4j
public class FailBackTolerantStrategy implements TolerantStrategy {
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 自行扩展实现
        return null;
    }
}
