package com.yocy.yirpc.server;

/**
 * HTTP 服务器接口
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface HttpServer {

    /**
     * 启动服务器
     * @param port
     */
    void doStart(int port);
}
