package com.zjh.distributed.service;

import com.zjh.distributed.lock.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author zhaojh
 * @date 2020/11/3 21:16
 */
@Service
@Slf4j
public class SchedulerService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    private void sendMsg() {
        try (RedisLock redisLock = new RedisLock(redisTemplate, "imissyou", 30)) {
            if (redisLock.getLock()) {
                log.info("我想你了。。。");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
