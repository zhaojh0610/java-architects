package com.zjh.tccdemo.controller;

import com.zjh.tccdemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh
 * @date 2020/11/9 19:53
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("payment")
    public int payment(int userId, int orderId, int amount) {
        return paymentService.payment(userId, orderId, amount);
    }

    /**
     * 基于mq实现分布式事务
     * @param userId
     * @param orderId
     * @param amount
     * @return
     */
    @RequestMapping("paymentMQ")
    public int paymentMQ(int userId, int orderId, int amount) throws Exception {
        return paymentService.paymentMQ(userId, orderId, amount);
    }
}
