package com.zjh.shardingjdbcdemo;

import com.zjh.shardingjdbcdemo.dao.AreaMapper;
import com.zjh.shardingjdbcdemo.dao.OrderItemMapper;
import com.zjh.shardingjdbcdemo.dao.OrderMapper;
import com.zjh.shardingjdbcdemo.model.*;
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
    @Resource
    private AreaMapper areaMapper;
    @Resource
    private OrderItemMapper orderItemMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        Order order = new Order();
        order.setUserId(131);
        order.setOrderAmount(10);
        order.setOrderStatus(2);
        orderMapper.insertSelective(order);
    }

    @Test
    public void testSelect() {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderIdEqualTo("3").andUserIdEqualTo(3);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        System.out.println(orders.size());
        System.out.println(orders.toString());
    }

    @Test
    public void testGlobal() {
        Area area = new Area();
        area.setId(2);
        area.setName("shanghai");
        areaMapper.insert(area);
    }

    @Test
    public void testSelectGlobal() {
        AreaExample areaExample = new AreaExample();
        areaExample.createCriteria().andIdEqualTo(2);
        List<Area> areas = areaMapper.selectByExample(areaExample);
        System.out.println("areas.size=" + areas.size());
    }

    @Test
    public void testBindTable() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1);
        orderItem.setOrderId(2);
        orderItem.setName("test");
        orderItem.setUserId(2);
        orderItemMapper.insert(orderItem);
    }

    @Test
    public void testMasterSlave() {
        for (int i = 0; i < 10; i++) {
            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria().andOrderIdEqualTo("2");
            List<Order> orders = orderMapper.selectByExample(orderExample);
            System.out.println("order_id=" + orders.get(0).getOrderId());
            System.out.println("order_amount=" + orders.get(0).getOrderAmount());
        }
    }
}
