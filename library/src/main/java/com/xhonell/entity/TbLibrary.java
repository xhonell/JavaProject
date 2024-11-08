package com.xhonell.entity;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class TbLibrary {

  private long libraryId;
  private String libraryName;
  private java.sql.Timestamp libraryCreateTime;
  private String libraryRemark;

  public TbLibrary() {
  }

  public TbLibrary(long libraryId, String libraryName, Timestamp libraryCreateTime, String libraryRemark) {
    this.libraryId = libraryId;
    this.libraryName = libraryName;
    this.libraryCreateTime = libraryCreateTime;
    this.libraryRemark = libraryRemark;
  }



}
