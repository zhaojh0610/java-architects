package com.zjh.distributedzklock.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaojh
 * @date 2020/11/3 22:11
 */
@Slf4j
public class ZkLock implements AutoCloseable, Watcher {

    private ZooKeeper zooKeeper;
    private String zNode;

    public ZkLock() throws IOException {
        this.zooKeeper = new ZooKeeper("192.168.120.131:2181,192.168.120.132:2181,192.168.120.133:2181", 10000, this);
    }

    public boolean getLock(String businessCode) throws KeeperException, InterruptedException {
        try {
            //  创建业务根节点
            Stat stat = zooKeeper.exists("/" + businessCode, false);
            if (stat == null) {
                zooKeeper.create("/" + businessCode, businessCode.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
            }
            //  创建瞬时有序节点 /order/order_00001
            zNode = zooKeeper.create("/" + businessCode + "/" + businessCode + "_", businessCode.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            //  获取业务节点下所有子节点
            List<String> childrenNodes = zooKeeper.getChildren("/" + businessCode, false);
            //  子节点排序
            Collections.sort(childrenNodes);
            //  获取序号最小的（第一个）子节点
            String firstNode = childrenNodes.get(0);
            //  如果创建的节点是第一个子节点，则获得锁
            if (zNode == firstNode) {
                return true;
            }
            //  不是第一个子节点，则监听前一个节点
            String lastNode = firstNode;
            for (String node : childrenNodes) {
                if (zNode.endsWith(node)) {
                    zooKeeper.exists("/" + businessCode + "/" + lastNode, true);
                    break;
                } else {
                    lastNode = node;
                }
            }
            synchronized (this) {
                wait();
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void close() throws Exception {
        zooKeeper.delete(zNode, -1);
        zooKeeper.close();
        log.info("我已经释放了锁。。。");
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeDeleted) {
            synchronized (this) {
                notify();
            }
        }
    }
}
