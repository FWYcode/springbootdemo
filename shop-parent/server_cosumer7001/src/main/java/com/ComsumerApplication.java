package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
@SpringBootApplication
@EnableDiscoveryClient

public class ComsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComsumerApplication.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getTemplat() {
        return new RestTemplate();
    }
}
