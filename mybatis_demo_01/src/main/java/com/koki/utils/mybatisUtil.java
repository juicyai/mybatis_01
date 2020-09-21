package com.koki.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatisUtil {

    public static SqlSessionFactory factory;
    //静态代码初始化静态变量
    static{
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            factory = factoryBuilder.build(is);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession = factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }



}
