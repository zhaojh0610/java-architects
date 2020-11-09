package com.zjh.tccdemo.consumer;

import com.zjh.tccdemo.service.OrderService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
import static org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus.RECONSUME_LATER;

/**
 * @author zhaojh
 * @date 2020/11/9 23:46
 */
@Component("messageListener")
public class ChangeOrderStatus implements MessageListenerConcurrently {

    @Autowired
    private DefaultMQPushConsumer consumer;
    @Autowired
    private OrderService orderService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (msgs.isEmpty()) {
            return CONSUME_SUCCESS;
        }
        for (MessageExt msg : msgs) {
            String topic = msg.getTopic();
            String body = new String(msg.getBody());
            System.out.println("topic:" + topic + " ,body:" + body);
            int orderId = Integer.parseInt(msg.getKeys());
            int i = orderService.handleOrder(orderId);
            if (i != 0) {
                return RECONSUME_LATER;
            }
        }
        return CONSUME_SUCCESS;
    }
}
