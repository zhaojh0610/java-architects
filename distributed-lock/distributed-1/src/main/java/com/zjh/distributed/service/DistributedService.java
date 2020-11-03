package com.zjh.distributed.service;

import com.zjh.distributed.dao.DistributedLockMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @date 2020/11/3 11:17
 */
@Service
@Slf4j
public class DistributedService {

    @Resource
    private DistributedLockMapper distributedLockMapper;

    public void sendMessage() {

    }


}
