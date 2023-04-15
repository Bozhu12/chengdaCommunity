package com.sans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.sans.mapper")
public class ChengdaCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChengdaCommunityApplication.class, args);

    }

}
