package com.jirengu.mybatis.mapper;

import com.jirengu.mybatis.pojo.Account;

import java.util.List;

public interface AccountMapper {
    Account selectAccount(int id);

    List<Account> selectAccountList(int money);

    int insertAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(int id);
}
