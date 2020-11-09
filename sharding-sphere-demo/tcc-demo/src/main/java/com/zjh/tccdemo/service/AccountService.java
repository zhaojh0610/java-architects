package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db129.dao.AccountAMapper;
import com.zjh.tccdemo.db129.model.AccountA;
import com.zjh.tccdemo.db130.dao.AccountBMapper;
import com.zjh.tccdemo.db130.model.AccountB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zhaojh
 * @date 2020/11/9 16:32
 */
@Service
public class AccountService {
    @Resource
    private AccountAMapper accountAMapper;
    @Resource
    private AccountBMapper accountBMapper;

    @Transactional(transactionManager = "tm129",rollbackFor = Exception.class)
    public void testAccount() {
        AccountA accountA = accountAMapper.selectByPrimaryKey(1);
        accountA.setBlance(accountA.getBlance().subtract(BigDecimal.valueOf(200)));
        accountAMapper.updateByPrimaryKey(accountA);

        AccountB accountB = accountBMapper.selectByPrimaryKey(2);
        accountB.setBlance(accountB.getBlance().add(BigDecimal.valueOf(200)));
        accountBMapper.updateByPrimaryKey(accountB);

        try {
            int i = 1 / 0;
        } catch (Exception exception) {
            AccountB accountb = accountBMapper.selectByPrimaryKey(2);
            accountb.setBlance(accountb.getBlance().subtract(BigDecimal.valueOf(200)));
            accountBMapper.updateByPrimaryKey(accountb);
            throw exception;
        }

    }
}
