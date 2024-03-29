package com.yocy.yirpc.serializer;

import java.io.IOException;

/**
 * 序列化器接口
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface Serializer {

    /**
     * 序列化
     * @param object
     * @return
     * @param <T>
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
      * @param bytes
     * @param type
     * @return
     * @param <T>
     */    
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
    
}
