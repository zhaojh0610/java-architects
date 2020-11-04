package com.zjh.distributedzklock.controller;

import com.zjh.distributedzklock.lock.ZkLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaojh
 * @date 2020/11/3 22:42
 */
@RestController
@Slf4j
public class ZookeeperController {

    @Autowired
    private CuratorFramework client;

    @RequestMapping("zooLock")
    public String zooLock() {
        try (ZkLock zkLock = new ZkLock()) {
            if (zkLock.getLock("order")) {
                log.info("我进入了锁。。。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "执行完毕。。。";
    }

    @RequestMapping("curatorLock")
    public String curatorLock() {
        log.info("我进入了方法。。。");
        InterProcessMutex lock = new InterProcessMutex(client, "/curator");
        try {
            if (lock.acquire(30, TimeUnit.SECONDS)) {
                log.info("我进入了锁。。。");

                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            log.info("我释放了锁。。。");
            try {
                lock.release();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        log.info("执行完毕了。。。");
        return "我执行完毕了。。。";
    }
}
