package com.dragon.blogservice.utils.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    public static<T> T  query(String sql, StudentRowMapper stm,Object...params){
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            //设置值
            for(int i = 0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
            }
            rs = ps.executeQuery();
            stm.mapping(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs,ps,conn);
        }
         return null;
    }
}
