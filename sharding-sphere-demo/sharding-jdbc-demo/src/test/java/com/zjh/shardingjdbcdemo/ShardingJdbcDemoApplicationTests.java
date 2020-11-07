package com.zjh.shardingjdbcdemo;

import com.zjh.shardingjdbcdemo.dao.OrderMapper;
import com.zjh.shardingjdbcdemo.model.Order;
import com.zjh.shardingjdbcdemo.model.OrderExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcDemoApplicationTests {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        Order order = new Order();
        order.setId(3);
        order.setUserId(3);
        order.setOrderAmount((long) 2);
        order.setOrderAmount((long) 2);
        order.setOrderStatus(2);
        orderMapper.insert(order);
    }

    @Test
    public void testSelect() {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(3).andUserIdEqualTo(3);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        System.out.println(orders.size());
        System.out.println(orders.toString());
    }
}
