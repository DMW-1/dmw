package com.sz.service;

import com.sz.pojo.Account;

import java.util.Map;

public interface AccountService {
    boolean existsCardNo(String cardNo);

    Account login(Account account);

    double queryBalance(String cardNo);

    Map<String, Object> transfer(Account sourceAccount,String cardNo, Double transactionAmount);
}
