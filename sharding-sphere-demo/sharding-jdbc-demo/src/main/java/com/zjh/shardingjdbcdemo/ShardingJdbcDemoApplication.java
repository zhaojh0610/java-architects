package com.zjh.shardingjdbcdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaojh
 */
@SpringBootApplication
@MapperScan("com.zjh.shardingjdbcdemo.dao")
//不使用spring命名空间配置
//@ImportResource("classpath*:sharding-jdbc.xml")
public class ShardingJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcDemoApplication.class, args);
    }

}
