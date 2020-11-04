package com.zjh.distributedzklock.controller;

import com.zjh.distributedzklock.lock.ZkLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhaojh
 * @date 2020/11/3 22:42
 */
@RestController
@Slf4j
public class ZookeeperController {

    @RequestMapping("zooLock")
    public String zooLock() {
        try (ZkLock zkLock = new ZkLock()){
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
}
