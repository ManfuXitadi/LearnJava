package com.jirengu.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;

public class DatabaseConnectionUtil {

    public static Connection getConnection() throws Exception{
        //1、配置连接池参数
        HashMap<String, Object> comfigMap = new HashMap<String, Object>();
        comfigMap.put("driverClassName", "com.mysql.cj.jdbc.Driver");
        comfigMap.put("url", "jdbc:mysql://127.0.0.1:3306/school");
        comfigMap.put("username", "root");
        comfigMap.put("password", "rootroot");
        // 初始连接数量
        comfigMap.put("initialSize", "5");
        // 最大连接数量
        comfigMap.put("maxActive", "10");
        //获取数据库连接时的最大等待时间
        //当连接池中的连接已经全部被占用，且没有空闲的连接可用时，新的数据库连接请求会进入等待队列
        //maxWait 参数指定了在等待队列中等待的最大时间，超过这个时间仍未获取到可用连接，则会抛出超时异常
        comfigMap.put("maxWait", "10000");
        // 2、 创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(comfigMap);
        // 3、从连接池对象中获取数据库连接
        return dataSource.getConnection();
    }



}
