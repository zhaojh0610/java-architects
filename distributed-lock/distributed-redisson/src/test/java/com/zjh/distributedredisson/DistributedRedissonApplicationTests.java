package com.zjh.distributedredisson;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
public class DistributedRedissonApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void redissonLock() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.120.128:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RLock rlock = redissonClient.getLock("zjh");
        log.info("我进入了方法。。。");
        rlock.lock(30, TimeUnit.SECONDS);
        log.info("我进入了锁...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log.info("我释放了锁。。。");
            rlock.unlock();
        }
        log.info("我执行完了。。。");
    }
}
