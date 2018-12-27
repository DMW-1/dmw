package com.sz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sz.dto.RecordDTO;
import com.sz.mapper.TransactionRecordMapper;
import com.sz.pojo.TransactionRecord;
import com.sz.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionRecordService {

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;


    @Override
    public PageInfo<TransactionRecord> queryByCardNo(RecordDTO recordDTO) {
        PageHelper.startPage(recordDTO.getPageNum(),recordDTO.getPageSize());
        List<TransactionRecord> l = transactionRecordMapper.queryByCardNo(recordDTO);

        PageInfo<TransactionRecord> page = new PageInfo<>(l);

//        return transactionRecordMapper.queryByCardNo(cardNo);
        return page;
    }
}
