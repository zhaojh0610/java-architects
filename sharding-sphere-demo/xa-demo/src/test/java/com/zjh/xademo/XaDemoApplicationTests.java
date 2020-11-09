package com.zjh.xademo;


import com.zjh.xademo.service.XaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class XaDemoApplicationTests {

    @Autowired
    private XaService xaService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testXa() {
        xaService.testXa();
    }



}


