package com.it.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/4/21 0021.
 */
@RestController
public class HelloBoyAction {
    @GetMapping("say/{name}")
    public String say(@PathVariable("name") String name) {
        return "hello"+name;

    }
}

