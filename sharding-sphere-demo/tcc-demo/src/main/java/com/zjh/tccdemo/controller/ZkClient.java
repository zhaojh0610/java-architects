package com.zjh.tccdemo.controller;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojh
 * @date 2020/11/10 23:41
 */
@Configuration
public class ZkClient {

    @Bean(initMethod = "start", destroyMethod = "close")
    public CuratorFramework getCuratorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3 );
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.120.132:2181", retryPolicy);
        return client;
    }
}
