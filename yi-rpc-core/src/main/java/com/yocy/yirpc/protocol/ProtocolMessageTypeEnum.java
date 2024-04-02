package com.yocy.yirpc.protocol;

import lombok.Getter;

/**
 * 协议消息类型枚举
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Getter
public enum ProtocolMessageTypeEnum {
    
    REQUEST(0),
    RESPONSE(1),
    HEART_BEAT(2),
    OTHER(3);
    
    private final int key;
    
    ProtocolMessageTypeEnum(int key) {
        this.key = key;
    }
    
    public static ProtocolMessageTypeEnum getEnumByKey(int key) {
        for (ProtocolMessageTypeEnum anEnum : ProtocolMessageTypeEnum.values()) {
            if (anEnum.key == key) {
                return anEnum;
            }
        }
        return null;
    }
}
