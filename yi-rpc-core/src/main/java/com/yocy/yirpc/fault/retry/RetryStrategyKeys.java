package com.yocy.yirpc.fault.retry;

/**
 * 重试策略键名常量
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface RetryStrategyKeys {

    /**
     * 不重试
     */
    String NO =  "no";

    /**
     * 固定时间间隔
     */
    String FIXED_INTERVAL = "fixedInterval";
}
