package com.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/4/23 0023.
 */
@Configuration
public class LoadBanceChoose {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
