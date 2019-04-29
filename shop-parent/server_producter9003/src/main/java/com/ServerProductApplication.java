package com;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2019/4/21 0021.
 */
@SpringBootApplication
@EnableDiscoveryClient
//@MapperScan(basePackages = "com.it.mapper.mymapper")
public class ServerProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerProductApplication.class);
    }
}
