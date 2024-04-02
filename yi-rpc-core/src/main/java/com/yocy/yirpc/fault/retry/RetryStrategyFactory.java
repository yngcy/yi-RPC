package com.yocy.yirpc.fault.retry;

import com.yocy.yirpc.spi.SpiLoader;

/**
 * 重试策略工厂（用于获取重试器对象）
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class RetryStrategyFactory {
    static {
        SpiLoader.load(RetryStrategy.class);
    }

    /**
     * 默认重试策略
     */
    
    private static final RetryStrategy DEFAULT_RETRY_STRATEGY = new NoRetryStrategy();

    /**
     * 获取实例
     * @param key
     * @return
     */
    public static RetryStrategy getInstance(String key) {
        return SpiLoader.getInstance(RetryStrategy.class, key);
    } 

}
