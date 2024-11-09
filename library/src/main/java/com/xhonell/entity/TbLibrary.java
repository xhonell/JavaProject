package com.xhonell.entity;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class TbLibrary {

    private long libraryId;
    private String libraryName;
    private java.sql.Timestamp libraryCreateTime;
    private String libraryRemark;

    /**
     * TbLibrary类的构造方法。
     */
    public TbLibrary() {
    }

    /**
     * TbLibrary 类的构造函数
     *
     * @param libraryId         图书馆ID
     * @param libraryName       图书馆名称
     * @param libraryCreateTime 图书馆创建时间
     * @param libraryRemark     图书馆备注
     */
    public TbLibrary(long libraryId, String libraryName, Timestamp libraryCreateTime, String libraryRemark) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.libraryCreateTime = libraryCreateTime;
        this.libraryRemark = libraryRemark;
    }


}
