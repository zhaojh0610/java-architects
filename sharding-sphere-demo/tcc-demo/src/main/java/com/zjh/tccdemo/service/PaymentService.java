package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db129.dao.AccountAMapper;
import com.zjh.tccdemo.db129.dao.PaymentMsgMapper;
import com.zjh.tccdemo.db129.model.AccountA;
import com.zjh.tccdemo.db129.model.PaymentMsg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhaojh
 * @date 2020/11/9 19:28
 */
@Service
public class PaymentService {

    @Resource
    private AccountAMapper accountAMapper;

    @Resource
    private PaymentMsgMapper paymentMsgMapper;

    /**
     * 支付接口
     *
     * @param userId
     * @param orderId
     * @param amount
     * @return 0：支付成功；1：用户不存在；2：余额不足
     */
    @Transactional(transactionManager = "tm129",rollbackFor = Exception.class)
    public int payment(int userId, int orderId, int amount) {
        AccountA accountA = accountAMapper.selectByPrimaryKey(userId);
        if (accountA == null) {
            return 1;
        }
        if (accountA.getBlance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            return 2;
        }
        accountA.setBlance(accountA.getBlance().subtract(BigDecimal.valueOf(amount)));
        accountAMapper.updateByPrimaryKey(accountA);

        PaymentMsg paymentMsg = new PaymentMsg();
        paymentMsg.setOrderId(orderId);
        paymentMsg.setStatus(0);
        paymentMsg.setFailureCnt(0);
        paymentMsg.setCreateUser(userId);
        paymentMsg.setCreateTime(new Date());
        paymentMsg.setUpdateUser(userId);
        paymentMsg.setUpdateTime(new Date());
        paymentMsgMapper.insert(paymentMsg);
        return 0;
    }

}

