package com.zjh.tccdemo.controller;

import com.zjh.tccdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh
 * @date 2020/11/9 20:22
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("handleOrder")
    public String handleOrder(int orderId) throws Exception {
        try {
            int result = orderService.handleOrder(orderId);
            if (result == 0) {
                return "success";
            }
            return "fail";
        } catch (Exception exception) {
            return "fail";
        }
    }
}
