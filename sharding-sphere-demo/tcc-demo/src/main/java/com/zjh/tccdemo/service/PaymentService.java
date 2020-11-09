package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db129.dao.AccountAMapper;
import com.zjh.tccdemo.db129.dao.PaymentMsgMapper;
import com.zjh.tccdemo.db129.model.AccountA;
import com.zjh.tccdemo.db129.model.PaymentMsg;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DefaultMQProducer producer;


    /**
     * 支付接口
     *
     * @param userId
     * @param orderId
     * @param amount
     * @return 0：支付成功；1：用户不存在；2：余额不足
     */
    @Transactional(transactionManager = "tm129", rollbackFor = Exception.class)
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

    /**
     * 支付接口(基于MQ实现分布式事务)
     *
     * @param userId
     * @param orderId
     * @param amount
     * @return 0：支付成功；1：用户不存在；2：余额不足
     */
    @Transactional(transactionManager = "tm129", rollbackFor = Exception.class)
    public int paymentMQ(int userId, int orderId, int amount) throws Exception {
        AccountA accountA = accountAMapper.selectByPrimaryKey(userId);
        if (accountA == null) {
            return 1;
        }
        if (accountA.getBlance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            return 2;
        }
        accountA.setBlance(accountA.getBlance().subtract(BigDecimal.valueOf(amount)));
        accountAMapper.updateByPrimaryKey(accountA);
        Message message = new Message();
        message.setTopic("payment");
        message.setKeys(String.valueOf(orderId));
        message.setBody("已支付".getBytes());
        try {
            SendResult result = producer.send(message);
            if (result.getSendStatus() == SendStatus.SEND_OK) {
                System.out.println("mq消息发送成功");
                return 0;
            } else {
                throw new Exception("MQ发送消息失败！");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}

