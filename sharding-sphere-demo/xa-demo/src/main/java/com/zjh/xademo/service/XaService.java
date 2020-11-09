package com.zjh.xademo.service;

import com.zjh.xademo.db129.dao.Xa129Mapper;
import com.zjh.xademo.db130.dao.Xa130Mapper;
import com.zjh.xademo.model.Xa129;
import com.zjh.xademo.model.Xa130;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @date 2020/11/8 14:40
 */
@Service
public class XaService {

    @Resource
    private Xa129Mapper xa129Mapper;

    @Resource
    private Xa130Mapper xa130Mapper;

    @Transactional(transactionManager = "xaTransaction")
    public void testXa() {
        Xa129 xa129 = new Xa129();
        xa129.setId(1231);
        xa129.setName("1123");
        xa129Mapper.insert(xa129);

        Xa130 xa130 = new Xa130();
        xa130.setId(1231);
        xa130.setName("1123");
        xa130Mapper.insert(xa130);
    }

}
