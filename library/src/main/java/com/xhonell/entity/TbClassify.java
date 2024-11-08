package com.xhonell.entity;

import lombok.Data;

@Data
public class TbClassify {

  private long claId;
  private String claName;


  public TbClassify() {
  }

  public TbClassify(long claId, String claName) {
    this.claId = claId;
    this.claName = claName;
  }
}
