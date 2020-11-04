package com.zjh.distributedredisson.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaojh
 * @date 2020/11/4 15:05
 */
@RestController
@Slf4j
public class RedissonLockController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("redissonLock")
    public String redissonLock() {
        RLock redissonLock = redissonClient.getLock("zjh");
        log.info("我进入了方法...");
        redissonLock.lock(30, TimeUnit.SECONDS);
        log.info("我获得了锁。。。");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            redissonLock.unlock();
        }
        log.info("我释放了锁。。。");
        return "执行完毕..";
    }
}
