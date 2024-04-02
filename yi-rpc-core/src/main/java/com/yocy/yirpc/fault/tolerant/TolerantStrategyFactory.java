package com.yocy.yirpc.fault.tolerant;

import com.yocy.yirpc.spi.SpiLoader;
import org.apache.jute.compiler.generated.TokenMgrError;

/**
 * 容错策略工厂（工厂模式，用于获取容错策略对象）
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class TolerantStrategyFactory {
    static {
        SpiLoader.load(TolerantStrategy.class);
    }

    /**
     * 默认容错策略
     */
    private static final TolerantStrategy DEFAULT_TOLERANT_STRATEGY = new FailFastTolerantStrategy();

    /**
     * 获取实例
     * @param key
     */
    public static TolerantStrategy getInstance(String key) {
        return SpiLoader.getInstance(TolerantStrategy.class, key);
    }
}
