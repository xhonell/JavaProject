package com.xhonell.entity;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class TbBorrow {

    private long bokId;
    private long stuId;
    private java.sql.Timestamp borTime;
    private java.sql.Timestamp retTime;

    /**
     * TbBorrow的构造函数。
     * 这是一个无参构造函数，用于创建TbBorrow类的实例。
     */
    public TbBorrow() {
    }

    /**
     * 创建一个 TbBorrow 对象
     *
     * @param bokId   图书的ID
     * @param stuId   学生的ID
     * @param borTime 借阅时间
     * @param retTime 归还时间
     */
    public TbBorrow(long bokId, long stuId, Timestamp borTime, Timestamp retTime) {
        this.bokId = bokId;
        this.stuId = stuId;
        this.borTime = borTime;
        this.retTime = retTime;
    }
}
