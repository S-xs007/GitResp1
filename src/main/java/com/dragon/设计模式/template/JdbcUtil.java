package com.dragon.blogservice.utils.template;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.LinkPermission;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    static Properties p;
    public JdbcUtil(){

    }
    static{
        try{
            //1.加载注册驱动
            ClassLoader  loader = Thread.currentThread().getContextClassLoader();
            InputStream in = loader.getResourceAsStream("db.properties");
            Properties p = new Properties();
            p.load(in);
            Class.forName(p.getProperty("driverClassName"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void close(ResultSet rs, Statement st,Connection conn){
        try{
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                if(st!=null){
                    st.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try{
                    if(conn!=null){
                        conn.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
