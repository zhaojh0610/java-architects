package com.zjh.distributedredisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaojh
 */
@SpringBootApplication
//@ImportResource(value = "classpath:redisson.xml")
public class DistributedRedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedRedissonApplication.class, args);
    }

}
