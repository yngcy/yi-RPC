package com.yocy.yirpc.protocol;

/**
 * 协议常量
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface ProtocolConstant {
    /**
     * 消息体长度
     */
    int MESSAGE_HEADER_LENGTH = 17;

    /**
     * 协议魔数
     */
    byte PROTOCOL_MEGIC = 0x1;

    /**
     * 协议版本号
     */
    byte PROTOCOL_VERSION = 0x1;
}
