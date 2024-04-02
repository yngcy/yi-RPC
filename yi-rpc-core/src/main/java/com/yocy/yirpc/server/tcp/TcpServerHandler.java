package com.yocy.yirpc.server.tcp;

import io.vertx.core.Handler;
import io.vertx.core.net.NetSocket;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class TcpServerHandler implements Handler<NetSocket> {
    @Override
    public void handle(NetSocket netSocket) {
        TcpBufferHandlerWrapper bufferHandlerWrapper = new TcpBufferHandlerWrapper(buffer -> {
            // 处理请求代码
        });
        netSocket.handler(bufferHandlerWrapper);
    }
}
