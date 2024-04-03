package com.yocy.yirpc.springboot.starter.annotation;

import com.yocy.yirpc.springboot.starter.bootstrap.RpcConsumerBootstrap;
import com.yocy.yirpc.springboot.starter.bootstrap.RpcInitBootstrap;
import com.yocy.yirpc.springboot.starter.bootstrap.RpcProviderBootstrap;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用 RPC 注解
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Import({RpcInitBootstrap.class, RpcProviderBootstrap.class, RpcConsumerBootstrap.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableRpc {
    /**
     * 需要启动 server
     * @return
     */
    boolean needServer() default true;
}
