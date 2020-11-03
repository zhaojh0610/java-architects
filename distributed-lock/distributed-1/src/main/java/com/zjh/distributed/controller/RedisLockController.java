package com.zjh.distributed.controller;

import com.zjh.distributed.lock.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh
 * @date 2020/11/3 16:12
 */
@RestController
@Slf4j
public class RedisLockController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("redisLock")
    public String redisLock() {
        log.info("我进入了方法：");
        String key = "redisKey";
        try (RedisLock redisLock = new RedisLock(redisTemplate, key, 30)) {
            if (redisLock.getLock()) {
                log.info("我进入了锁。。。");
                Thread.sleep(15000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("执行完毕。。。");
        return "执行完毕。。。";
    }
}
