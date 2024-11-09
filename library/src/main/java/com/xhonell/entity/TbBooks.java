package com.xhonell.entity;


import lombok.Data;

@Data
public class TbBooks {

    private long bokId;
    private String bokName;
    private String bokStatu;

    /**
     * TbBooks类的无参构造函数。
     */
    public TbBooks() {
    }

    /**
     * 构造方法，用于创建TbBooks对象
     *
     * @param bokId    书籍ID
     * @param bokName  书籍名称
     * @param bokStatu 书籍状态
     */
    public TbBooks(long bokId, String bokName, String bokStatu) {
        this.bokId = bokId;
        this.bokName = bokName;
        this.bokStatu = bokStatu;
    }

}
