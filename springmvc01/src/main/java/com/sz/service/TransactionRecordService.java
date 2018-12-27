package com.sz.service;

import com.github.pagehelper.PageInfo;
import com.sz.dto.RecordDTO;
import com.sz.pojo.TransactionRecord;

import java.util.List;

public interface TransactionRecordService {
    PageInfo<TransactionRecord> queryByCardNo(RecordDTO recordDTO);


}
