package com.jirengu.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class LearnMyBatisService {
    public static void main(String[] args) throws Exception{
        //加载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream iNputStream = Resources.getResourceAsStream(resource);
        //获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(iNputStream);
        //获取 SqlSession 对象，用于执行 SQL
        SqlSession session = sqlSessionFactory.openSession();
        //执行SQL
        Account account = session.selectOne("AccountMapper.selectAccount",1);
        System.out.println(account);
        //释放资源
        session.close();
    }
}
