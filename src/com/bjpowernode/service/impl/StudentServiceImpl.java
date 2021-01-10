package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAll() {
        List<Student> sList = studentDao.getAll();
        return sList;
    }

    @Override
    public int save(Student s) {
        return studentDao.save(s);
    }

    @Override
    public void updateStudent(String id, String name, int age) {
        studentDao.updateStudent(id,name,age);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public List<Student> select17(Student s) {
        List<Student> sList = studentDao.select17(s);
        return sList;
    }

    @Override
    public List<Student> select18(String[] strArr) {
        List<Student> sList = studentDao.select18(strArr);
        return sList;
    }

    @Override
    public Student select19(String id) {
        Student s = studentDao.select19(id);
        return s;
    }
}
