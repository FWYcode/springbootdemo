package com.it.server.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/4/21 0021.
 */
@RestController
public class Redestie {
    @GetMapping("redestie")
    public String to() {
        return "11";
    }
}
