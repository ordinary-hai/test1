package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface StudentDao {
    //根据id差单条
    Student getById(String id);
    //查询所有
    List<Student> getAll();

     int save(Student s);

    void updateStudent(@Param("id") String id,@Param("name") String name,@Param("age") int age);

    void deleteStudent(String id);

    List<Student> select17(Student s);

    List<Student> select18(String[] strArr);

    Student select19(String id);

    List<Map<String, Object>> select20();
}
