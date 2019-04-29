package com.it.action;

import com.it.service.RemotGetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
@RestController
public class GetDataAction {
    @Autowired
    private RemotGetData remotGetData;

    @GetMapping("find/{id}")
    public String getData(@PathVariable(name = "id") Integer id) {
        return remotGetData.RPCgetmethod(id);
    }

    @GetMapping("findall")
    public String doAll() {
        return remotGetData.RPCgetAlldata();
    }
}


