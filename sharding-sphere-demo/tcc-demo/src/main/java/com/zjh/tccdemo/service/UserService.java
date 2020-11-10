package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db129.dao.UserMapper;
import com.zjh.tccdemo.db129.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhaojh
 * @date 2020/11/10 15:18
 */
@Service
@Slf4j
public class UserService {
    @Resource
    private UserMapper userMapper;

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
}
