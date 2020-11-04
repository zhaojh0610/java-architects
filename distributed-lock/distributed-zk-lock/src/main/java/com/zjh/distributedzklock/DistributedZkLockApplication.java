package com.zjh.distributedzklock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zhaojh
 */
@SpringBootApplication
public class DistributedZkLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedZkLockApplication.class, args);
    }

    @Bean(initMethod = "start",destroyMethod = "close")
    public CuratorFramework getCuratorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.120.131:2181", retryPolicy);
        return client;
    }
}
