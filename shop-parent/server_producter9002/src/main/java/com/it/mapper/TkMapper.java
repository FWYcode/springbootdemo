package com.it.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
public interface TkMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
