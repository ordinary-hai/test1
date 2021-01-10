package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }

    //代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;

        try {
            session = SqlSessionUtil.getSession();
            //如果业务逻辑方法没有返回值，那就返回一个null
            obj = method.invoke(target,args);
            //处理事务
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }

    public Object getProxy(){
        //为了取得代理对象(得到ls对象)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

}
