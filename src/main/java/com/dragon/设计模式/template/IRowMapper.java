package com.dragon.blogservice.utils.template;

import java.sql.ResultSet;
import java.util.List;

public interface IRowMapper<T> {
    //处理结果集
    T mapping(ResultSet rs)throws Exception;
}
