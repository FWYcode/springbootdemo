package com.it.action;

import com.alibaba.fastjson.JSON;
import com.fwy.pojo.TbItem;
import com.it.mapper.mymapper.Mapperd;
import com.it.mapper.mymapper.MyMapper;
import com.it.pojo.dto.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
@RestController
public class DataAction {
    @Autowired
    private MyMapper mapper;
    @Autowired
    private Mapperd mapperd;
    @GetMapping("find/{stuid}")
    public String addStu( @PathVariable(name = "stuid") Integer stuid) {
        Entry entry=mapper.selectByPrimaryKey(stuid);
        System.out.println(entry);
        String s = JSON.toJSONString(entry);
        return s+"I am 9001";

    }

    @GetMapping("findall")
    public String findAll() {

        List<TbItem> all = mapperd.findAll();
        return JSON.toJSONString(all);


    }

}

