package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db130.dao.OrderMapper;
import com.zjh.tccdemo.db130.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zhaojh
 * @date 2020/11/9 20:15
 */
@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 更新订单状态接口
     * @param orderId
     * @return 0：更新成功；1：订单不存在；
     */
    public int handleOrder(int orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            return 1;
        }
        //  已支付
        order.setOrderStatus(1);
        order.setUpdateTime(new Date());
        order.setUpdateUser(0);
        orderMapper.updateByPrimaryKey(order);
        return 0;
    }

}
