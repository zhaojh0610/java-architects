package com.zjh.distributedzklock;

import com.zjh.distributedzklock.lock.ZkLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DistributedZkLockApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testZkLock() throws Exception {
        ZkLock zkLock = new ZkLock();
        boolean result = zkLock.getLock("order");
        log.info("获得锁的结果：" + result);
        zkLock.close();
    }

}
