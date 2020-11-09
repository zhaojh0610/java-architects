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
}
