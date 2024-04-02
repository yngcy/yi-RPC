package com.yocy.yirpc.protocol;

import com.yocy.yirpc.model.RpcRequest;
import com.yocy.yirpc.model.RpcResponse;
import com.yocy.yirpc.serializer.Serializer;
import com.yocy.yirpc.serializer.SerializerFactory;
import io.vertx.core.buffer.Buffer;

import java.io.IOException;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class ProtocolMessageDecoder {
    
    public static ProtocolMessage<?> decode(Buffer buffer) throws IOException {
        // 分别从指定位置取出 Buffer
        ProtocolMessage.Header header = new ProtocolMessage.Header();
        byte magic = buffer.getByte(0);
        // 校验魔数
        if (magic != ProtocolConstant.PROTOCOL_MEGIC) {
            throw new RuntimeException("消息 magic 非法");
        }
        header.setMagic(magic);
        header.setVersion(buffer.getByte(1));
        header.setSerializer(buffer.getByte(2));
        header.setType(buffer.getByte(3));
        header.setStatus(buffer.getByte(4));
        header.setRequestId(buffer.getLong(5));
        header.setBodyLength(buffer.getInt(13));
        // 解决粘包问题
        byte[] bodyBytes = buffer.getBytes(17, 17 + header.getBodyLength());
        // 解析消息体
        ProtocolMessageSerializerEnum serializerEnum = ProtocolMessageSerializerEnum.getEnumByKey(header.getSerializer());
        if (serializerEnum == null) {
            throw new RuntimeException("序列化消息的协议不存在");
        }
        Serializer serializer = SerializerFactory.getInstance(serializerEnum.getValue());
        ProtocolMessageTypeEnum messageType = ProtocolMessageTypeEnum.getEnumByKey(header.getType());
        if (messageType == null) {
            throw new RuntimeException("序列化消息的类型不存在");
        }
        switch (messageType) {
            case REQUEST:
                RpcRequest request = serializer.deserialize(bodyBytes, RpcRequest.class);
                return new ProtocolMessage<>(header, request);
            case RESPONSE:
                RpcResponse response = serializer.deserialize(bodyBytes, RpcResponse.class);
                return new ProtocolMessage<>(header, response);
            case HEART_BEAT:
            case OTHER:
            default:
                throw new RuntimeException("暂时不支持该消息类型");
        }
    }
}
