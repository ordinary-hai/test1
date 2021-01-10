package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Student getById(String id);

    List<Student> getAll();

    int save(Student s);

    void updateStudent(String id, String name, int age);

    void deleteStudent(String id);

    List<Student> select17(Student s);

    List<Student> select18(String[] strArr);

    Student select19(String id);


}
