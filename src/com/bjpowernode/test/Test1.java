package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        //StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
        //根据id查单条
        /*Student s = ss.getById("A0005");
        System.out.println("数据:"+s);*/
        //查询所有数据
        /*List<Student> sList = ss.getAll();
        for (Student s : sList){
            System.out.println("数据:"+s);
        }*/
        //添加
        /*Student s = new Student();
        s.setId("A0005");
        s.setName("黄忠");
        s.setAge(44);

        ss.save(s);*/
        //根据id更改数据
        /*ss.updateStudent("A0005","黄忠",44);*/

        //根据删除
        /*ss.deleteStudent("A0005");*/

        //--------------------------------------------
        //动态sql

        //测试：动态sql where和if标签
        /*Student s = new Student();
        s.setName("刘");
        s.setAddress("d");
        List<Student> sList = ss.select17(s);
        for (Student s1 : sList){
            System.out.println(s1);
        }*/

        //测试：动态sql foreach标签
        /*String strArr[] = {"A0001","A0002","A0003"};
        List<Student> sList = ss.select18(strArr);
        for(Student s1:sList){
            System.out.println(s1);
        }*/

        //测试：sql片段
        /*Student s = ss.select19("A0006");
        System.out.println(s);*/

        //20.测试:多表联查  查询出学生姓名和班级名称
        List<Map<String,Object>> mapList = studentDao.select20();
        for(Map<String,Object> map : mapList){
            Set<String> set = map.keySet();
            for(String key:set){
                System.out.println("key:"+key);
                System.out.println("value:"+map.get(key));
            }
            System.out.println("--------------------------------------");

        }

    }
}
