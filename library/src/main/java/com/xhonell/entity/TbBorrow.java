package com.xhonell.entity;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class TbBorrow {

  private long bokId;
  private long libId;
  private java.sql.Timestamp borTime;
  private java.sql.Timestamp retTime;

  public TbBorrow() {
  }

  public TbBorrow(long bokId, long libId, Timestamp borTime, Timestamp retTime) {
    this.bokId = bokId;
    this.libId = libId;
    this.borTime = borTime;
    this.retTime = retTime;
  }
}
