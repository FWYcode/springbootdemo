package com.it.mapper.mymapper;

import com.fwy.dao.TbItemMapper;
import com.fwy.pojo.TbItem;
import com.fwy.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
@Service
public class Mapperd {
    @Autowired
    TbItemMapper tbItemMapper;

    public List<TbItem> findAll() {
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria().andIdIsNotNull();
        example.or(criteria);
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        return tbItems;
    }

}
