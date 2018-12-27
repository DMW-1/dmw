package com.sz.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 数据传输对象
 */
public class RecordDTO {

    private Integer pageSize;

    private Integer pageNum;

    private String cardNo;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "yyyy-mm-dd")
//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date start;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date end;


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
