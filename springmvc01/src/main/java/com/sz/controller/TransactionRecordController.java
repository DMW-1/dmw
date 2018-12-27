package com.sz.controller;

import com.github.pagehelper.PageInfo;
import com.sz.dto.RecordDTO;
import com.sz.pojo.TransactionRecord;
import com.sz.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/transactionRecord")
public class TransactionRecordController {

    @Autowired
    private TransactionRecordService transactionRecordService;

    @RequestMapping("/query")
    public String queryAllByTime(RecordDTO recordDTO, Model model){

        // 查询所有的交易记录
        PageInfo<TransactionRecord> page  = transactionRecordService.queryByCardNo(recordDTO);

        model.addAttribute("page","record");
        model.addAttribute("pageInfo",page);
        return "main";

    }

    @RequestMapping("/index")
    public String index( Model model){
        model.addAttribute("page","record");
        return "main";

    }
}
