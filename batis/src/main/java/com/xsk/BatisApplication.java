package com.xsk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "com.xsk")
public class BatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatisApplication.class, args);
    }
}
