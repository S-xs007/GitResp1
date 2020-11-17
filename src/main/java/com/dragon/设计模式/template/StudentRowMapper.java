package com.dragon.blogservice.utils.template;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRowMapper implements IRowMapper<List<Student>>{
    @Override
    public List<Student> mapping(ResultSet rs) throws Exception {
        List<Student> list = new ArrayList<>();
        long id = rs.getLong("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        Student stu = new Student(id,name,age);
        list.add(stu);
        return list;
    }
}
