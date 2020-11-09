package com.zjh.tccdemo.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojh
 * @date 2020/11/9 22:59
 */
@Configuration
public class RocketmqConfig {

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public DefaultMQProducer producer() {
        DefaultMQProducer producer = new DefaultMQProducer("paymentGroup");
        producer.setNamesrvAddr("127.0.0.1:9876");
        return producer;
    }

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public DefaultMQPushConsumer pushConsumer(@Qualifier("messageListener") MessageListenerConcurrently messageListener) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("paymentConsumerGroup");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("payment", "*");
        consumer.registerMessageListener(messageListener);
        return consumer;
    }
}
