package com.it.mapper.mymapper;

import com.it.mapper.TkMapper;
import com.it.pojo.dto.Entry;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
@Mapper
public interface MyMapper extends TkMapper<Entry> {
}
