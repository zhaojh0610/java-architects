package com.zjh.tccdemo.service;

import com.zjh.tccdemo.db129.dao.PaymentMsgMapper;
import com.zjh.tccdemo.db129.model.PaymentMsg;
import com.zjh.tccdemo.db129.model.PaymentMsgExample;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhaojh
 * @date 2020/11/9 20:45
 */
@Service
public class OrderScheduler {

    @Resource
    private PaymentMsgMapper paymentMsgMapper;
    @Resource
    private OrderService orderService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void orderNotify() throws IOException {
        PaymentMsgExample paymentMsgExample = new PaymentMsgExample();
        paymentMsgExample.createCriteria().andStatusEqualTo(0);
        List<PaymentMsg> paymentMsgs = paymentMsgMapper.selectByExample(paymentMsgExample);
        if (paymentMsgs.isEmpty()) {
            return;
        }
        for (PaymentMsg paymentMsg : paymentMsgs) {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("http://localhost:8080/handleOrder");
            int orderId = paymentMsg.getOrderId();
            NameValuePair nameValuePair = new BasicNameValuePair("orderId", orderId + "");
            List<NameValuePair> list = new ArrayList<>();
            list.add(nameValuePair);
            HttpEntity entity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(entity);
            CloseableHttpResponse resp = httpClient.execute(httpPost);
            String result = EntityUtils.toString(resp.getEntity());
            Integer failureCnt = paymentMsg.getFailureCnt();
            if ("success".equals(result)) {
                paymentMsg.setStatus(1);
                paymentMsg.setUpdateTime(new Date());
                paymentMsg.setUpdateUser(0);
            } else {
                failureCnt++;
                paymentMsg.setStatus(0);
                paymentMsg.setFailureCnt(failureCnt);
                paymentMsg.setUpdateUser(0);
                paymentMsg.setUpdateTime(new Date());
                if (failureCnt >= 5) {
                    paymentMsg.setStatus(2);
                }
            }
            paymentMsgMapper.updateByPrimaryKey(paymentMsg);
        }
    }

}