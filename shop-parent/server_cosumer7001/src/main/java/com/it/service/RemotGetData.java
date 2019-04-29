package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
@Service
public class RemotGetData {
    @Value("${spring.application.name}")
    private String appServerName;
    @Autowired
    private RestTemplate restTemplate;
    public String RPCgetmethod(Integer id) {
        System.out.println(appServerName);
        return restTemplate.getForObject("http://server-producter/find/"+id,String.class);
    }

    public String RPCgetAlldata() {

        return restTemplate.getForObject("http://server-producter/findall", String.class);
    }

}

