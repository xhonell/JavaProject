package com.xhonell.entity;


import lombok.Data;

@Data
public class TbBooks {

    private long bokId;
    private long bokName;
    private String bokStatu;

    public TbBooks() {
    }

    public TbBooks(long bokId, long bokName, String bokStatu) {
        this.bokId = bokId;
        this.bokName = bokName;
        this.bokStatu = bokStatu;
    }
}
