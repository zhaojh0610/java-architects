package com.zjh.distributed.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaojh
 * @date 2020/11/2 17:39
 */
@RestController
@Slf4j
public class DemoController {

    private final Lock lock = new ReentrantLock();

    @RequestMapping("/singleLock")
    public String singleLock() throws InterruptedException {
        log.info("我进入了singleLock方法。。。");
        lock.lock();
        try {
            log.info("我进入了锁。。。");
            Thread.sleep(60000);
        } finally {
            lock.unlock();
        }
        return "我已经执行完成。。。";
    }
}
