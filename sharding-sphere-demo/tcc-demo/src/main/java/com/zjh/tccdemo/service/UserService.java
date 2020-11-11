package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db129.dao.UserMapper;
import com.zjh.tccdemo.db129.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaojh
 * @date 2020/11/10 15:18
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private CuratorFramework zkClient;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;

    public int del(int userId) {
        User users = userMapper.selectByPrimaryKey(userId);
        if (users == null) {
            log.info("用户不存在，userID=" + userId);
            return 0;
        }
        log.info("用户存在，userID=" + userId);
        return userMapper.deleteByPrimaryKey(userId);
    }

    public List<User> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        log.info("总共有" + userList.size() + "个用户");
        return userList;
    }

    public User userDetail(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public Integer registerLockByZK(User user) throws Exception {
        InterProcessMutex lock = new InterProcessMutex(zkClient, "/" + user.getUsername());
        boolean isLock = lock.acquire(40, TimeUnit.SECONDS);
        if (isLock) {
            log.info(user.getUsername() + "获得了锁");
            return userMapper.insertSelective(user);
        }
        return 0;
    }

    public Integer registerLockByRedisson(User user, String token) throws InterruptedException {
        RLock lock = redissonClient.getLock(token);
        boolean isLock = lock.tryLock(1, TimeUnit.SECONDS);
        if (isLock) {
            log.info(user.getUsername() + "获得了锁");
            int i = userMapper.insertSelective(user);
            return i;
        }
        return 0;
    }


}
