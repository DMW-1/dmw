package com.sz.service.impl;

import com.sz.constant.StatusCodeConstant;
import com.sz.mapper.AccountMapper;
import com.sz.mapper.TransactionRecordMapper;
import com.sz.pojo.Account;
import com.sz.pojo.TransactionRecord;
import com.sz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    @Override
    public boolean existsCardNo(String cardNo) {
        int count = accountMapper.existsCardNo(cardNo);
        return count == 1 ? true:false;
    }

    @Override
    public Account login(Account account) {

       Account a =  accountMapper.queryByCardNoPwd(account.getCardNo(),account.getPassword());

        return a;
    }

    @Override
    public double queryBalance(String cardNo) {
        return accountMapper.queryBalance(cardNo);
    }

    @Override
    public Map<String, Object> transfer(Account sourceAccount,String cardNo, Double transactionAmount) {
        Map<String,Object> map = new HashMap<>();
        int code = StatusCodeConstant.NOT_EXISTS;
        String msg = null;
        // 1 检查账号是否存在，不存在直接失败
        int row = accountMapper.existsCardNo(cardNo);
        if(row == 1){
            // 代表目标账号存在
            code = StatusCodeConstant.EXISTS;


            // 检查是否被冻结
            row = accountMapper.freeZon(cardNo);
            if(row == 1){
                // 激活
                // 检查余额
               row = accountMapper.balanceEnough(sourceAccount.getCardNo(),transactionAmount);
               if(row == 1){
                   // 余额够，转账

                   // 第一步，目标账号+钱
                   accountMapper.plusMoney(cardNo,transactionAmount);
                   // 第二步，目标账号-钱
                   accountMapper.minusMoney(sourceAccount.getCardNo(),transactionAmount);
                   // 第三部，产生交易记录
                   TransactionRecord transactionRecord = new TransactionRecord();
                   transactionRecord.setCardNo(sourceAccount.getCardNo());
                   transactionRecord.setTransactionAmount(transactionAmount);
                   transactionRecord.setTransactionType("转账");
                   transactionRecord.setTransactionDate(new Date());
                   // 重新查询balance
                   double balance = accountMapper.queryBalance(sourceAccount.getCardNo());
                   transactionRecord.setBalance(balance);

                   transactionRecordMapper.insert(transactionRecord);
                   code = StatusCodeConstant.SUCCESS;
                   msg = StatusCodeConstant.SUCCESS_MSG;

               } else {
                   // 余额不足 不会出现任何的直接字符串
                   code = StatusCodeConstant.BALANCE_NOT_ENOUGH;
                   msg = StatusCodeConstant.BALANCE_NOT_ENOUGH_MSG;
               }
            } else {
                // 冻结
                code = StatusCodeConstant.FREEZON;
                msg = StatusCodeConstant.FREEZON_MSG;
            }
        } else {

            msg = StatusCodeConstant.NOT_EXISTS_MSG;
        }
        // else情况，默认code赋值就是不存在，所以无需额外处理

        // 2 账号存在， 是否被冻结


        // 3 账号存在，激活，但是10 100万，也不行

        // 4 转账成功，必须一方加钱成功，另一方减钱成功。


        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
}
