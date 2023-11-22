package com.jirengu.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;

public class LearnJDBCService {

    public static void main(String[] args) throws Exception {
        // 1、1 注册驱动 -- 告诉程序底层用的是哪个数据库  Class.forName = 类加载 高版本可以自行注册，不用写代码
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 1、2 获取连接
//        String url = "jdbc:mysql://localhost:3306/school";  // localhost = 127.0.0.1
//        String user = "root";
//        String password = "rootroot";
//        Connection connection = DriverManager.getConnection(url, user, password);
        // 1、3 定义SQL语句

        //配置Druid连接池，取巧，就没有用配置文件的形式了
//        HashMap<String, Object> comfigMap = new HashMap<String, Object>();
//        comfigMap.put("driverClassName", "com.mysql.cj.jdbc.Driver");
//        comfigMap.put("url", "jdbc:mysql://127.0.0.1:3306/school");
//        comfigMap.put("username", "root");
//        comfigMap.put("password", "rootroot");
//        comfigMap.put("initialSize", "5");
//        comfigMap.put("maxActive", "10");
//        comfigMap.put("maxWait", "10000");
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(comfigMap);
//        Connection connection = dataSource.getConnection();
        Connection connection = DatabaseConnectionUtil.getConnection();
//        try {
//            // 开启事务
//            connection.setAutoCommit(false);
//            String sql1 = "update account set money = 1111 where id = 1;";
//            String sql2 = "update account set money = 1111 where id = 19;";
//            // 1、4 执行SQL语句
//
////        int count =
//            statement.executeUpdate(sql1);
//            statement.executeUpdate(sql2);
//
//            //提交事务
//            connection.commit();
//        }catch (Exception e) {
//            //回滚事务
//            connection.rollback();
//        }
//        String insertSQL = "insert into account (name,money) values ('Tom',2000)";
//        String updateSQL = "update account set money = 1222 where id =1";
//        String deleteSQL = "delete from account where id = 111111";
//        int insertCount = statement.executeUpdate(insertSQL);
//        int updateCount = statement.executeUpdate(updateSQL);
//        int deleteCount = statement.executeUpdate(deleteSQL);
//        System.out.println("插入数据" + insertCount + "条");
//        System.out.println("更新数据" + updateCount + "条");
//        System.out.println("插入数据" + deleteCount + "条");
//        String selectSql = "select * from account";
//        ResultSet resultSet = statement.executeQuery(selectSql);
//        //ResultSet 像迭代器
//        while(resultSet.next()){
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            int money = resultSet.getInt("money");
//            Account account = new Account();
//            account.setId(id);
//            account.setMoney(money);
//            account.setName(name);
//            System.out.println(account);
//        }

//        Statement statement = connection.createStatement();
//        //用户输入的id和密码
//        int userId = 1;
//        String userPassword = "abc";
//        String sql = "select * from user_password where user_id = " + userId + " and user_password = '" + userPassword + "'";
//        System.out.println(sql);
//        ResultSet resultSet = statement.executeQuery(sql);
//        if(resultSet.next()){
//            System.out.println("用户名密码核验通过，登录成功~");
//        }else{
//            System.out.println("用户名密码核验不通过，登录失败~");
//        }
        //sql语句先定义，不确定的值用？（英文状态下）先进行占位
        String sql = "select * from user_password where user_id = ? and user_password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //用户输入的id和密码
//        int userId = 1111111;
        int userId = 1;
//        String userPassword = "or '1' = '1'";
        String userPassword = "abc";
        preparedStatement.setInt(1,userId);
        preparedStatement.setString(2,userPassword);
//        System.out.println(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("用户名密码核验通过，登录成功~");
        }else{
            System.out.println("用户名密码核验不通过，登录失败~");
        }


//        System.out.println("更新数据" + count + "条");
        // 1、5 释放资源
        preparedStatement.close();
//        connection.close();
    }

    private static class Account{
        private Integer id;
        private String name;
        private Integer money;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getMoney() {
            return money;
        }

        public void setMoney(Integer money) {
            this.money = money;
        }
    }
}
