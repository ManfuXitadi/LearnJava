package com.jirengu.mybatis;

import com.jirengu.mybatis.mapper.AccountMapper;
import com.jirengu.mybatis.mapper.AccountMapperImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class LearnMyBatisService {
    public static void main(String[] args) throws Exception{
        //加载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream iNputStream = Resources.getResourceAsStream(resource);
        //获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(iNputStream);
        //获取 SqlSession 对象，用于执行 SQL
        SqlSession session = sqlSessionFactory.openSession();

//        //执行SQL
//        //selectOne
//        Account account = session.selectOne("AccountMapper.selectAccount",1);
//        System.out.println(account);
////        //selectList
//        List<Account> accountList = session.selectList("AccountMapper.selectAccountList",1000);
//        System.out.println(accountList);
//        //insert
//        Account insertAccount = new Account();
//        insertAccount.setName("Mary");
//        insertAccount.setMoney(1500);
//        int countInsert = session.insert("AccountMapper.insertAccount", insertAccount);
//        System.out.println("插入数据" + countInsert + "条");
//        //update
//        Account updateAccount = new Account();
//        updateAccount.setId(23);
//        updateAccount.setMoney(99999);
//        int countUpdate = session.update("AccountMapper.updateAccount", updateAccount);
//        System.out.println("更新数据" + countUpdate + "条");
//        //delete
//        int countDelete = session.delete("AccountMapper.deleteAccount", 31);
//        System.out.println("删除数据" + countDelete + "条");

//        //手动创建AccountMapperImpl实现类的使用方式
//        AccountMapper accountMapper = new AccountMapperImpl(session);
//        Account account = accountMapper.selectAccount(1);
//        System.out.println(account);

        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        //执行SQL
        //selectOne
        Account account = accountMapper.selectAccount(1);
        System.out.println(account);
//        //selectList
        List<Account> accountList = accountMapper.selectAccountList(1000);
        System.out.println(accountList);
        //insert
        Account insertAccount = new Account();
        insertAccount.setName("salor");
        insertAccount.setMoney(15000);
        int countInsert = accountMapper.insertAccount(insertAccount);
        System.out.println("插入数据" + countInsert + "条");
        //update
        Account updateAccount = new Account();
        updateAccount.setId(23);
        updateAccount.setMoney(121);
        int countUpdate = accountMapper.updateAccount(updateAccount);
        System.out.println("更新数据" + countUpdate + "条");
        //delete
        int countDelete = accountMapper.deleteAccount(35);
        System.out.println("删除数据" + countDelete + "条");

//        //事务默认是开启的，需要手动提交，执行的SQL语句才会在数据库中生效
        session.commit();
        //释放资源
        session.close();
    }
}
