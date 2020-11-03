package com.zjh.distributed.controller;

import com.zjh.distributed.dao.DistributedLockMapper;
import com.zjh.distributed.model.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @author zhaojh
 * @date 2020/11/2 17:39
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private DistributedLockMapper distributedLockMapper;

    @RequestMapping("/singleLock")
    @Transactional(rollbackOn = Exception.class)
    public String singleLock() throws Exception {
        log.info("我进入了singleLock方法。。。");
        DistributedLock distributedLock = distributedLockMapper.selectDistributedLock("zjh");
        if (distributedLock == null) {
            throw new Exception("分布式锁找不到！");
        }
        log.info("我进入了锁。。。");
        Thread.sleep(60000);
        return "我已经执行完成。。。";
    }
}
