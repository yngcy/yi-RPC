package com.yocy.yirpc.protocol;

import lombok.Getter;

/**
 * 协议消息的状态枚举
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Getter
public enum ProtocolMessageStatusEnum {
    OK("ok", 20),
    BAD_REQUEST("bad_request", 40),
    BAD_RESPONSE("bad_response", 50);
    
    private final String text;
    
    private final int value;
    
    ProtocolMessageStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     * @param value
     * @return
     */
    public static ProtocolMessageStatusEnum getEnumByValue(int value) {
        for (ProtocolMessageStatusEnum anEnum : ProtocolMessageStatusEnum.values()) {
            if (anEnum.value == value) {
                return anEnum;
            }
        }
        return null;
    }
}
