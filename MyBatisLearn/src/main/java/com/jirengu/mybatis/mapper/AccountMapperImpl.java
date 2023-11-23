package com.jirengu.mybatis.mapper;

import com.jirengu.mybatis.Account;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountMapperImpl implements AccountMapper{

    private SqlSession session;

    public AccountMapperImpl(SqlSession session) {
        this.session = session;
    }


    public Account selectAccount(int id) {
        String namespace = this.getClass().getInterfaces()[0].getName();
        String sqlId = Thread.currentThread().getStackTrace()[1].getMethodName();
        String sqlFullName = namespace + "." + sqlId;
        return session.selectOne(sqlFullName,id);
    }

    public List<Account> selectAccountList(int money) {
        return null;
    }

    public int insertAccount(Account account) {
        return 0;
    }

    public int updateAccount(Account account) {
        return 0;
    }

    public int deleteAccount(int id) {
        return 0;
    }
}
