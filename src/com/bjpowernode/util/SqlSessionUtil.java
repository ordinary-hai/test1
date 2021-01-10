package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    //构造方法私有化，防止产生垃圾
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    //1、获取SqlSession对象
    public static SqlSession getSession(){
        SqlSession session = t.get();
        if (session == null){
            session = sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }

    //2、关闭SqlSession对象
    public static void myClose(SqlSession session){
        if (session != null){
            session.close();
            //这句必须交（非常容易忘记）
            t.remove();
        }
    }
}
